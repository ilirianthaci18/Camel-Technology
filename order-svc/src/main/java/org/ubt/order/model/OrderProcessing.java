package org.ubt.order.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ubt.order.common.enums.PaymentStatus;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class OrderProcessing {
    @Id
    @SequenceGenerator(name = "order_processing_sequence", sequenceName = "order_processing_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_processing_sequence")
    @Column
    private int id;

    @Column
    private PaymentStatus status;

    //@Column
   // private Order orderDetails;

   // @Column
    //private Purchase purchase;
}
