package hms.sessions.mspace.otp.subscription.sample.client;

import hms.sessions.mspace.otp.subscription.sample.client.messages.PlatformSendOtpRequest;
import hms.sessions.mspace.otp.subscription.sample.client.messages.PlatformSendOtpResponse;
import hms.sessions.mspace.otp.subscription.sample.client.messages.PlatformVerifyOtpRequest;
import hms.sessions.mspace.otp.subscription.sample.client.messages.PlatformVerifyOtpResponse;

public interface PlatformConnector {
    PlatformSendOtpResponse requestOtp(PlatformSendOtpRequest request);

    PlatformVerifyOtpResponse verifyOtp(PlatformVerifyOtpRequest request);
}
