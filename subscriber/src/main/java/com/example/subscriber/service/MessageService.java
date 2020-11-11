package com.example.subscriber.service;

import com.example.subscriber.dao.PurchaseDao;
import com.example.subscriber.dao.SubscriptionDao;
import com.example.subscriber.dto.MessageRequest;
import com.example.subscriber.repository.PurchaseRepository;
import com.example.subscriber.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MessageService {
    private final PurchaseRepository purchaseRepository;
    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public MessageService(PurchaseRepository purchaseRepository,
                          SubscriptionRepository subscriptionRepository) {
        this.purchaseRepository = purchaseRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    @Transactional
    public void handleMessage(MessageRequest request) {
        switch (request.getAction()) {
            case PURCHASE:
                createPurchase(request);
                break;
            case SUBSCRIPTION:
                createSubscription(request);
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    private void createPurchase(MessageRequest request) {
        PurchaseDao purchaseDao = new PurchaseDao();
        purchaseDao.setMsisdn(request.getMsisdsn());
        purchaseDao.setTimestamp(request.getTimestamp());

        purchaseRepository.save(purchaseDao);
    }

    private void createSubscription(MessageRequest request) {
        SubscriptionDao subscriptionDao = new SubscriptionDao();
        subscriptionDao.setMsisdn(request.getMsisdsn());
        subscriptionDao.setTimestamp(request.getTimestamp());

        subscriptionRepository.save(subscriptionDao);
    }
}
