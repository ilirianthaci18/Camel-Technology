package org.ubt.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.ubt.order.common.dto.ProductDTOOrder;
import org.ubt.order.common.enums.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Order {
    @Id
    @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    @Column
    private int id;

    @Column
    private String orderType;

    @Column
    private LocalDateTime ordered;

    @Column
    private LocalDateTime shipped;

    @Column
    private String ship_to;

    @Column
    private String shippingId;

    @Column
    private String userEmail;

    //@Column
    //private User customer;

    @Column
    private OrderStatus status;

    @Column
    private double totalPrice;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<ProductDTOOrder> orderItems;

}
