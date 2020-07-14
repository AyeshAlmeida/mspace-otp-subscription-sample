package hms.sessions.mspace.otp.subscription.sample.client;

import hms.sessions.mspace.otp.subscription.sample.client.messages.PlatformSendOtpRequest;
import hms.sessions.mspace.otp.subscription.sample.client.messages.PlatformSendOtpResponse;
import hms.sessions.mspace.otp.subscription.sample.client.messages.PlatformVerifyOtpRequest;
import hms.sessions.mspace.otp.subscription.sample.client.messages.PlatformVerifyOtpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class PlatformConnectorImpl implements PlatformConnector {
    private final RestTemplate requestSender;

    @Value("${platform.connector.url}")
    private String baseUrl = "http://localhost:7000";

    @Autowired
    public PlatformConnectorImpl(RestTemplate template) {
        this.requestSender = template;
    }

    @Override
    public PlatformSendOtpResponse requestOtp(PlatformSendOtpRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<PlatformSendOtpRequest> requestEntity = new HttpEntity<>(request, headers);
        return requestSender
                .exchange(
                        baseUrl + "/subscription/otp/request",
                        HttpMethod.POST,
                        requestEntity,
                        PlatformSendOtpResponse.class)
                .getBody();
    }

    @Override
    public PlatformVerifyOtpResponse verifyOtp(PlatformVerifyOtpRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<PlatformVerifyOtpRequest> requestEntity = new HttpEntity<>(request, headers);
        return requestSender
                .exchange(
                        baseUrl + "/subscription/otp/verify",
                        HttpMethod.POST,
                        requestEntity,
                        PlatformVerifyOtpResponse.class)
                .getBody();
    }
}
