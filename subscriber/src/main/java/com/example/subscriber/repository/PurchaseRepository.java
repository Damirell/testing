package com.example.subscriber.repository;

import com.example.subscriber.dao.PurchaseDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseDao, Long> {
}
