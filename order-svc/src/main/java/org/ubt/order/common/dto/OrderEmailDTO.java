package org.ubt.order.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderEmailDTO {
    private String email;
    private String ship_to;
    private String orderStatus;
    private double totalPrice;
    private LocalDateTime ordered;
    private LocalDateTime shipped;
}
