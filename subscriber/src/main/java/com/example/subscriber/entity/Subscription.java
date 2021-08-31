package com.example.subscriber.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "SUBSCRIPTION")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUBSCRIPTION_SEQ")
    @SequenceGenerator(name = "SUBSCRIPTION_SEQ", initialValue = 10000, allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MSISDN", nullable = false, unique = true)
    private Integer msisdn;

    @Column(name = "CREATED", nullable = false)
    private LocalDateTime created;
}
