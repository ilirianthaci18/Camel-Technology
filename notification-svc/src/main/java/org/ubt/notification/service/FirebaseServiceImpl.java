package org.ubt.notification.service;

import com.google.firebase.messaging.*;
import org.springframework.stereotype.Service;
import org.ubt.notification.model.DirectNotification;
import org.ubt.notification.model.SubscriptionRequest;
import org.ubt.notification.model.TopicNotification;

@Service
public class FirebaseServiceImpl implements FirebaseService{

    @Override
    public void sendNotificationToTarget(DirectNotification notification) {
        var message= Message.builder()
                .setWebpushConfig(WebpushConfig.builder().setNotification(
                        WebpushNotification.builder()
                                .setTitle(notification.getTitle())
                                .setBody(notification.getMessage())
                                .setIcon("https://assets.mapquestapi.com/icon/v2/circle@2x.png")
                                .build()
                        ).build()
                ).setToken(notification.getTarget()).build();

        FirebaseMessaging.getInstance().sendAsync(message);
    }

    @Override
    public void sendNotificationToTopic(TopicNotification notification) {
        var message= Message.builder()
                .setWebpushConfig(WebpushConfig.builder().setNotification(
                                WebpushNotification.builder()
                                        .setTitle(notification.getTitle())
                                        .setBody(notification.getMessage())
                                        .setIcon("https://assets.mapquestapi.com/icon/v2/circle@2x.png")
                                        .build()
                        ).build()
                ).setTopic(notification.getTopic()).build();

        FirebaseMessaging.getInstance().sendAsync(message);
    }

    @Override
    public void subscribeToTopic(SubscriptionRequest subscriptionRequest) throws FirebaseMessagingException {
        FirebaseMessaging.getInstance().subscribeToTopic(subscriptionRequest.getSubscriber(),subscriptionRequest.getTopic());
    }
}
