package hms.sessions.mspace.otp.subscription.sample.client.messages;

import java.util.Map;

public class PlatformSendOtpRequest {
    private String applicationId;
    private String password;
    private String subscriberId;
    private String applicationHash;
    private Map<String, Object> applicationMetaData;

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

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
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
}
