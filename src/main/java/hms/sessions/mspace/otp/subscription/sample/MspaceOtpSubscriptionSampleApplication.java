package hms.sessions.mspace.otp.subscription.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MspaceOtpSubscriptionSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MspaceOtpSubscriptionSampleApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
