package com.example.subscriber.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PURCHASE")
public class PurchaseDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MSISDN")
    private Integer msisdn;

    @Column(name = "TIMESTAMP")
    private Long timestamp;
}
