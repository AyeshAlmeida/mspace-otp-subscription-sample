package hms.sessions.mspace.otp.subscription.sample.client.messages;

public class PlatformVerifyOtpRequest {
    private String applicationId;
    private String password;
    private String referenceNo;
    private String otp;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlatformVerifyOtpRequest{");
        sb.append("applicationId='").append(applicationId).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", referenceNo='").append(referenceNo).append('\'');
        sb.append(", otp='").append(otp).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
