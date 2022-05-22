package org.ubt.notification.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionRequest {
    private String topic;
    private List<String> subscriber;

    private void addToListOfSubscriber(String subscriber){
        this.subscriber.add(subscriber);
    }
}
