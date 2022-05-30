package org.ubt.order.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ubt.order.common.enums.CurrencyStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Price {
    @Id
    @SequenceGenerator(name = "price_sequence", sequenceName = "price_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "price_sequence")
    @Column
    private int id;

   // @Column
    //private Location location;

    @Column
    private double price;

    @Column
    private double discountPercentage;

    @Column
    private String priceStartDate;

    @Column
    private String priceEndDate;

    @Column
    private String currency;

    @Column
    private double currencyRate;

    @Column
    private double exchangeRateWithEuro;

    @Column
    private double taxPercentage;

    @Column
    private CurrencyStatus status;

}
