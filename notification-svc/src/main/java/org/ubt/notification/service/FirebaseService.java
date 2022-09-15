package org.ubt.notification.service;

import com.google.firebase.messaging.FirebaseMessagingException;
import org.ubt.notification.model.DirectNotification;
import org.ubt.notification.model.SubscriptionRequest;
import org.ubt.notification.model.TopicNotification;

public interface FirebaseService {
    void sendNotificationToTarget(DirectNotification notification);
    void sendNotificationToTopic(TopicNotification notification);
    void subscribeToTopic(SubscriptionRequest subscriptionRequest) throws FirebaseMessagingException;
}
