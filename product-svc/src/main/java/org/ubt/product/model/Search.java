package org.ubt.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Search {
    private int id;

    private List<String> searchText;

    private List<String> listOfReferences;

    private List<Product> content;
}
