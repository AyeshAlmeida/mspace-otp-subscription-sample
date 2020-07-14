package hms.sessions.mspace.otp.subscription.sample.client.messages;

public class PlatformSendOtpResponse extends PlatformResponse {
    private String referenceNo;

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlatformSendOtpResponse{");
        sb.append("referenceNo='").append(referenceNo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
