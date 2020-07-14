package hms.sessions.mspace.otp.subscription.sample.service.impl;

import hms.sessions.mspace.otp.subscription.sample.client.PlatformConnector;
import hms.sessions.mspace.otp.subscription.sample.messages.SendOtpRequest;
import hms.sessions.mspace.otp.subscription.sample.messages.SendOtpResponse;
import hms.sessions.mspace.otp.subscription.sample.messages.VerifyOtpRequest;
import hms.sessions.mspace.otp.subscription.sample.messages.VerifyOtpResponse;
import hms.sessions.mspace.otp.subscription.sample.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtpServiceImpl implements OtpService {
    private final PlatformConnector connector;

    @Autowired
    public OtpServiceImpl(PlatformConnector connector) {
        this.connector = connector;
    }

    //todo: implement following methods properly
    @Override
    public SendOtpResponse sendOtp(SendOtpRequest request) {
        return null;
    }

    @Override
    public VerifyOtpResponse verifyOtp(VerifyOtpRequest request) {
        return null;
    }
}
