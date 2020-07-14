package hms.sessions.mspace.otp.subscription.sample.messages;

public class VerifyOtpRequest {
    private String trxId;
    private String verificationCode;

    public String getTrxId() {
        return trxId;
    }

    public void setTrxId(String trxId) {
        this.trxId = trxId;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VerifyOtpRequest{");
        sb.append("trxId='").append(trxId).append('\'');
        sb.append(", verificationCode='").append(verificationCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
