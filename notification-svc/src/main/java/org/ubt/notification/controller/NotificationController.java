package org.ubt.notification.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.ubt.notification.model.DirectNotification;
import org.ubt.notification.model.SubscriptionRequest;
import org.ubt.notification.model.TopicNotification;
import org.ubt.notification.service.FirebaseService;

@Slf4j
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class NotificationController {
    private FirebaseService firebaseService;

    public NotificationController(FirebaseService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @PostMapping("/notification")
    public void sendTargetedNotification(@RequestBody DirectNotification notification){
        firebaseService.sendNotificationToTarget(notification);
    }

    @PostMapping("/topic/notification")
    public void sendNotificationToTopic(@RequestBody TopicNotification notification){
        firebaseService.sendNotificationToTopic(notification);
    }

    @PostMapping("/topic/subscription")
    public void subscribeToTopic(@RequestBody SubscriptionRequest subscription) throws FirebaseMessagingException {
        firebaseService.subscribeToTopic(subscription);
    }
}
