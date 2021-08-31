package com.example.subscriber.repository;

import com.example.subscriber.entity.Subscription;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends LongJpaRepository<Subscription> {
}
