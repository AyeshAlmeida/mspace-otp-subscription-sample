package hms.sessions.mspace.otp.subscription.sample.repository;

import hms.sessions.mspace.otp.subscription.sample.repository.domain.AppSubscription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends CrudRepository<AppSubscription, Long> {
    Optional<AppSubscription> findByDeviceId(String deviceId);

    @Query("UPDATE AppSubscription sub SET sub.isSubscribed = :isSubscribed, sub.maskedMsisdn = :maskedMsisdn where sub.deviceId = :deviceId")
    void updateByDeviceId(@Param("deviceId") String deviceId, @Param("isSubscribed") boolean isSubscribed, @Param("maskedMsisdn") String maskedMsisdn);
}
