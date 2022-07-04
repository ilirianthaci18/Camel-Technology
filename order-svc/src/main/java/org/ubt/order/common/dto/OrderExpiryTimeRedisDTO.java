package org.ubt.order.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderExpiryTimeRedisDTO {

    private String id;

    private LocalDateTime ordered;

    private LocalDateTime expiryTimeOrder;

    private double totalPrice;

    private String customerEmail;

    List<String> productCode;
}
