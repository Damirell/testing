package com.example.subscriber.repository;

import com.example.subscriber.dao.SubscriptionDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionDao, Long> {
}
