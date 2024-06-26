package org.ubt.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.User;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.ubt.order.common.enums.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "_order")
public class Order {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column
    private String id;

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
    private String couponCode;

    @Enumerated(EnumType.STRING)
    @Column
    private OrderStatus status;

    @Column
    private double totalPrice;

    @Column
    private String customerEmail;

    @ElementCollection
    @CollectionTable(name="product_code",joinColumns =@JoinColumn(name="_order_id"))
    @Column(name="product_codes")
    List<String> productCode;
}
