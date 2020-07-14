package hms.sessions.mspace.otp.subscription.sample.messages;

import java.util.Map;

public class SendOtpRequest {
    private String mobileNumber;
    private String applicationHash;
    private Map<String, Object> applicationMetaData;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getApplicationHash() {
        return applicationHash;
    }

    public void setApplicationHash(String applicationHash) {
        this.applicationHash = applicationHash;
    }

    public Map<String, Object> getApplicationMetaData() {
        return applicationMetaData;
    }

    public void setApplicationMetaData(Map<String, Object> applicationMetaData) {
        this.applicationMetaData = applicationMetaData;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SendOtpRequest{");
        sb.append("mobileNumber='").append(mobileNumber).append('\'');
        sb.append(", applicationHash='").append(applicationHash).append('\'');
        sb.append(", applicationMetaData=").append(applicationMetaData);
        sb.append('}');
        return sb.toString();
    }
}
