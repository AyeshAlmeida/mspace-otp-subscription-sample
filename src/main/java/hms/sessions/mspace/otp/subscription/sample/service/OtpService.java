package hms.sessions.mspace.otp.subscription.sample.service;

import hms.sessions.mspace.otp.subscription.sample.messages.SendOtpRequest;
import hms.sessions.mspace.otp.subscription.sample.messages.SendOtpResponse;
import hms.sessions.mspace.otp.subscription.sample.messages.VerifyOtpRequest;
import hms.sessions.mspace.otp.subscription.sample.messages.VerifyOtpResponse;

public interface OtpService {
    SendOtpResponse sendOtp(String deviceId, SendOtpRequest request);

    VerifyOtpResponse verifyOtp(String deviceId, VerifyOtpRequest request);
}
