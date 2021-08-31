package com.example.subscriber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface LongJpaRepository <T> extends JpaRepository<T, Long> {
}
