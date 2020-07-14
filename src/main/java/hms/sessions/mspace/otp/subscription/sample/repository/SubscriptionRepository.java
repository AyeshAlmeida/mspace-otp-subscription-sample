package hms.sessions.mspace.otp.subscription.sample.repository;

import hms.sessions.mspace.otp.subscription.sample.repository.domain.AppSubscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends CrudRepository<AppSubscription, Long> {
}
