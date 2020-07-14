package hms.sessions.mspace.otp.subscription.sample.controller;

import hms.sessions.mspace.otp.subscription.sample.messages.SendOtpRequest;
import hms.sessions.mspace.otp.subscription.sample.messages.SendOtpResponse;
import hms.sessions.mspace.otp.subscription.sample.messages.VerifyOtpRequest;
import hms.sessions.mspace.otp.subscription.sample.messages.VerifyOtpResponse;
import hms.sessions.mspace.otp.subscription.sample.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/otp")
public class OtpFlowController {
    private final OtpService service;

    @Autowired
    public OtpFlowController(OtpService service) {
        this.service = service;
    }

    @RequestMapping(value = "/request", method = RequestMethod.POST)
    public SendOtpResponse sendOtp(@RequestHeader("device.id") String deviceId,
                                   @RequestBody SendOtpRequest request) {
        return service.sendOtp(deviceId, request);
    }

    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public VerifyOtpResponse verifyOtp(@RequestHeader("device.id") String deviceId,
                                       @RequestBody VerifyOtpRequest request) {
        return service.verifyOtp(deviceId, request);
    }
}
