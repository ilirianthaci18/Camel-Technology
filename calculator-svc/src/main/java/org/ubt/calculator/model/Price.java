package org.ubt.calculator.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {

    private int id;

    private double price;

    private double discountPercentage;

    private String priceStartDate;

    private String priceEndDate;

    private String currency;

    private double currencyRate;

    private double exchangeRateWithEuro;

    private double taxPercentage;

}
