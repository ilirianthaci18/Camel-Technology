package org.ubt.notification.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.ubt.notification.config.dto.FirebaseResponse;
import org.ubt.notification.config.dto.PushNotification;

@FeignClient(name="notification",url="https://fcm.googleapis.com/fcm/send")
public interface NotificationClient {
    @PostMapping()
    FirebaseResponse sendNotification(@RequestHeader("Authorization") String authorization, PushNotification pushNotification);
}
