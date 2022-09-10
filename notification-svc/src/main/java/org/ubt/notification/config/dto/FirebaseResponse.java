package org.ubt.notification.config.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirebaseResponse {

    private String multicast_id;
    private int success;
    private int failure;
    private int canonical_ids;
    private Result[] results;
}
