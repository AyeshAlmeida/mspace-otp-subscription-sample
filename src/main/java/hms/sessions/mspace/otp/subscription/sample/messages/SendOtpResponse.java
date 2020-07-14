package hms.sessions.mspace.otp.subscription.sample.messages;

public class SendOtpResponse {
    private String statusCode;
    private String description;
    private String trxId;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrxId() {
        return trxId;
    }

    public void setTrxId(String trxId) {
        this.trxId = trxId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SendOtpResponse{");
        sb.append("statusCode='").append(statusCode).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", trxId='").append(trxId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
