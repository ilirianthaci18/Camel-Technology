package org.ubt.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Data
public class OrderStatusDTO {

    private String orderId;
    private String shipTo;
    private List<String> productCodes;
    private boolean status;
//    private String customerEmail;
}
