package hms.sessions.mspace.otp.subscription.sample.service.impl;

import hms.sessions.mspace.otp.subscription.sample.client.PlatformConnector;
import hms.sessions.mspace.otp.subscription.sample.client.messages.PlatformSendOtpRequest;
import hms.sessions.mspace.otp.subscription.sample.client.messages.PlatformSendOtpResponse;
import hms.sessions.mspace.otp.subscription.sample.client.messages.PlatformVerifyOtpRequest;
import hms.sessions.mspace.otp.subscription.sample.client.messages.PlatformVerifyOtpResponse;
import hms.sessions.mspace.otp.subscription.sample.messages.SendOtpRequest;
import hms.sessions.mspace.otp.subscription.sample.messages.SendOtpResponse;
import hms.sessions.mspace.otp.subscription.sample.messages.VerifyOtpRequest;
import hms.sessions.mspace.otp.subscription.sample.messages.VerifyOtpResponse;
import hms.sessions.mspace.otp.subscription.sample.repository.SubscriptionRepository;
import hms.sessions.mspace.otp.subscription.sample.repository.domain.AppSubscription;
import hms.sessions.mspace.otp.subscription.sample.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OtpServiceImpl implements OtpService {
    private final PlatformConnector connector;
    private final SubscriptionRepository repository;

    @Value("${platform.app-id}")
    private String appId = "APP_000000";
    @Value("${platform.password}")
    private String password = "password";

    @Autowired
    public OtpServiceImpl(PlatformConnector connector,
                          SubscriptionRepository repository) {
        this.connector = connector;
        this.repository = repository;
    }

    @Override
    public SendOtpResponse sendOtp(String deviceId, SendOtpRequest request) {
        Optional<AppSubscription> appSubscriptionOpt = repository.findByDeviceId(deviceId);

        if (appSubscriptionOpt.isPresent() && appSubscriptionOpt.get().isSubscribed()) {
            SendOtpResponse response = new SendOtpResponse();
            response.setStatusCode("E1001");
            response.setDescription("User already registered");
            return response;
        } else {
            PlatformSendOtpRequest platformRequest = getSendOtpRequest(request);

            PlatformSendOtpResponse platformResponse = connector.requestOtp(platformRequest);

            createSubscriptionEntry(deviceId, platformResponse);

            return getSendOtpResponse(platformResponse);
        }
    }

    private SendOtpResponse getSendOtpResponse(PlatformSendOtpResponse platformResponse) {
        SendOtpResponse response = new SendOtpResponse();
        response.setStatusCode(platformResponse.getStatusCode());
        response.setDescription(platformResponse.getStatusDetail());
        response.setTrxId(platformResponse.getReferenceNo());
        return response;
    }

    private void createSubscriptionEntry(String deviceId, PlatformSendOtpResponse platformResponse) {
        if ("S1000".equalsIgnoreCase(platformResponse.getStatusCode())) {
            AppSubscription subscription = new AppSubscription();
            subscription.setDeviceId(deviceId);
            subscription.setSubscribed(false);
            repository.save(subscription);
        }
    }

    private PlatformSendOtpRequest getSendOtpRequest(SendOtpRequest request) {
        PlatformSendOtpRequest platformRequest = new PlatformSendOtpRequest();
        platformRequest.setApplicationId(appId);
        platformRequest.setPassword(password);
        platformRequest.setSubscriberId("tel:"+request.getMobileNumber());
        platformRequest.setApplicationHash(request.getApplicationHash());
        platformRequest.setApplicationMetaData(request.getApplicationMetaData());
        return platformRequest;
    }

    @Override
    public VerifyOtpResponse verifyOtp(String deviceId, VerifyOtpRequest request) {
        Optional<AppSubscription> appSubscriptionOpt = repository.findByDeviceId(deviceId);
        if (appSubscriptionOpt.isPresent() && appSubscriptionOpt.get().isSubscribed()) {
            VerifyOtpResponse response = new VerifyOtpResponse();
            response.setStatusCode("E1001");
            response.setDescription("User already registered");
            return response;
        } else {
            if (appSubscriptionOpt.isPresent()) {
                PlatformVerifyOtpRequest platformRequest = getVerifyOtpRequest(request);

                PlatformVerifyOtpResponse platformResponse = connector.verifyOtp(platformRequest);

                updateSubscription(deviceId, platformResponse);

                return getVerifyOtpResponse(platformResponse);
            } else {
                VerifyOtpResponse response = new VerifyOtpResponse();
                response.setStatusCode("E1002");
                response.setDescription("Could not find the subscription for given device");
                return response;
            }
        }
    }

    private VerifyOtpResponse getVerifyOtpResponse(PlatformVerifyOtpResponse platformResponse) {
        VerifyOtpResponse response = new VerifyOtpResponse();
        response.setStatusCode(platformResponse.getStatusCode());
        response.setDescription(platformResponse.getStatusDetail());
        return response;
    }

    private void updateSubscription(String deviceId, PlatformVerifyOtpResponse platformResponse) {
        if ("S1000".equalsIgnoreCase(platformResponse.getStatusCode()) &&
                "REGISTERED".equalsIgnoreCase(platformResponse.getSubscriptionStatus())) {
            repository.updateByDeviceId(deviceId, true, platformResponse.getSubscriberId());
        }
    }

    private PlatformVerifyOtpRequest getVerifyOtpRequest(VerifyOtpRequest request) {
        PlatformVerifyOtpRequest platformRequest = new PlatformVerifyOtpRequest();
        platformRequest.setApplicationId(appId);
        platformRequest.setPassword(password);
        platformRequest.setReferenceNo(request.getTrxId());
        platformRequest.setOtp(request.getVerificationCode());
        return platformRequest;
    }
}
