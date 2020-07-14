package hms.sessions.mspace.otp.subscription.sample.client.messages;

public class PlatformResponse {
    private String version;
    private String statusCode;
    private String statusDetail;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDetail() {
        return statusDetail;
    }

    public void setStatusDetail(String statusDetail) {
        this.statusDetail = statusDetail;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlatformResponse{");
        sb.append("version='").append(version).append('\'');
        sb.append(", statusCode='").append(statusCode).append('\'');
        sb.append(", statusDetail='").append(statusDetail).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
