package org.ubt.product.service;

import org.ubt.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts() throws InterruptedException;
}
