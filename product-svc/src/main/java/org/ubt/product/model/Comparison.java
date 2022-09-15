package org.ubt.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comparison {
    private int id;

    private boolean notInterested;

    private List<Product> content;

    private double ratings;

    private String display;

    private String processor;

    private String battery;

    private String storage;

    private double weight;

    private double width;
}
