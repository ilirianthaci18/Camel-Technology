package org.ubt.product.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.ubt.product.model.Product;
import org.ubt.product.repository.ProductRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init() {
        Product product = new Product("Iphone", "iphxii", "This is a new iphone", "test", "m4ha",
                LocalDateTime.now(),true,  true, 1555, 00, "smartphone", "black", 10,
                112, 1, 22.2, true, 2.2, 10);

        productRepository.save(product);
    }

    @Cacheable("products")
    public List<Product> getProducts() throws InterruptedException {
        log.info("Calling service to get Products data...");
        log.debug("This is debug Calling service to get Products data...");
        return productRepository.findAll();
    }

}