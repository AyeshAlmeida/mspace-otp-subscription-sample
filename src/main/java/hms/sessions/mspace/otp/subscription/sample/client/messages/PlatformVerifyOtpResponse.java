package hms.sessions.mspace.otp.subscription.sample.client.messages;

public class PlatformVerifyOtpResponse extends PlatformResponse {
    private String subscriptionStatus;
    private String subscriberId;

    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(String subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlatformVerifyOtpResponse{");
        sb.append("subscriptionStatus='").append(subscriptionStatus).append('\'');
        sb.append(", subscriberId='").append(subscriberId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
