package com.example.subscriber.repository;

import com.example.subscriber.entity.Purchase;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends LongJpaRepository<Purchase> {
}
