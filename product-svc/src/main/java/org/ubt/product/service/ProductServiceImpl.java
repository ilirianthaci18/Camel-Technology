package org.ubt.product.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.ubt.product.model.Product;
import org.ubt.product.repository.ProductRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
            Product iphone = new Product("Iphone 13 Pro","IP13P","Newest iPhone is now live with us",
                    "New Brand Iphone","Battery","../src/assets/images/2.png",LocalDateTime.now(),true,true, 1350.00,12,"Mobiles","Sierra Blue",2.53,203,5.78,1.7,true,4.5,1);

            Product samsung = new Product("Samsung S22 Ultra","SMS22U","Newest product of Samsung","New Brand","batterytest","../src/assets/images/3.png",
                    LocalDateTime.now(),true,true,1200,
                    15,"Mobiles","White",2.53,200,5.83,2.4,true,4.4,1);

        Product watch = new Product("Apple Watch Series 7","AW7","Newest product of apple watches","New Brand","800MAH","../src/assets/images/1.png",
                LocalDateTime.now(),true,true,1200,
                15,"Mobiles","White",2.53,200,5.83,2.4,true,4.4,7);

        Product iphone13 = new Product("iPhone13","IP13","Newest product of mobile phones from apple","New Brand","2800MAH","../src/assets/images/4.png",
                LocalDateTime.now(),true,false,999.99,
                10,"Mobiles","White",2.53,200,5.83,2.4,true,4.4,10);

        Product iphone12 = new Product("iPhone12","IP12","Newest product of mobile phones from apple","New Brand","1800MAH","../src/assets/images/6.png",
                LocalDateTime.now(),true,false,799.99,
                10,"Mobiles","White",2.53,200,5.83,2.4,true,4.4,9);

        Product galaxyTab = new Product("Galaxy Tab A8","IP13","Newest product of mobile phones from Samsung","New Brand","2800MAH","../src/assets/images/12.png",
                LocalDateTime.now(),true,false,999.99,
                10,"Mobiles","White",2.53,200,5.83,2.4,true,4.4,5);

        Product mouse = new Product("Gaming Mouse","GM1","Newest product of gaming accessories","New Brand","280MAH","../src/assets/images/15.png",
                LocalDateTime.now(),true,false,99.99,
                10,"Gaming","Black",2.53,200,5.83,2.4,true,4.4,5);

        Product iphone11 = new Product("Iphone11","IP11","Newest product of apple","New Brand","280MAH","../src/assets/images/6.png",
                LocalDateTime.now(),true,false,99.99,
                10,"Mobiles","Blue",2.53,200,5.83,2.4,true,4.4,5);


        List<Product> products = new ArrayList<>();

        products.add(iphone);
        products.add(samsung);
        products.add(watch);
        products.add(iphone13);
        products.add(iphone12);
        products.add(galaxyTab);
        products.add(mouse);
        products.add(iphone11);





        Iterable<Product> products1 = productRepository.saveAll(products);
    }

    @Cacheable("products")
    public List<Product> getProducts() throws InterruptedException {
        log.info("Calling service to get Products data...");
        log.debug("This is debug Calling service to get Products data...");
        return productRepository.findAll();
    }

}