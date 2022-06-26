package org.ubt.calculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Exchange {
    private String from;
    private String to;
    private Double amount;
}
