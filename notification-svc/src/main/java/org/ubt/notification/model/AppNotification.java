package org.ubt.notification.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppNotification {
    @JsonProperty("title")
    private String title;
    @JsonProperty("message")
    private String message;
}
