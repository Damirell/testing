package com.example.subscriber.service;

import com.example.subscriber.entity.Purchase;
import com.example.subscriber.entity.Subscription;
import com.example.subscriber.dto.MessageRequest;
import com.example.subscriber.exception.UnknownActionException;
import com.example.subscriber.repository.PurchaseRepository;
import com.example.subscriber.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final PurchaseRepository purchaseRepository;
    private final SubscriptionRepository subscriptionRepository;

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
                throw new UnknownActionException();
        }
    }

    private void createPurchase(MessageRequest request) {
        Purchase newPurchase = Purchase.builder()
                .msisdn(request.getMsisdn())
                .created(request.getTimestamp())
                .build();

        purchaseRepository.save(newPurchase);
    }

    private void createSubscription(MessageRequest request) {
        Subscription newSubscription = Subscription.builder()
                .msisdn(request.getMsisdn())
                .created(request.getTimestamp())
                .build();

        subscriptionRepository.save(newSubscription);
    }
}
