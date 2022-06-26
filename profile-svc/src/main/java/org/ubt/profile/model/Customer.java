package org.ubt.profile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int id;
    private String postalCode;
    private String billindAddress;
    private String shippingAddress;
    private String city;
    private String state;
    private List<Recommendation> recommendations;
    private List<HistoricalOrder> historicalOrders;
}

