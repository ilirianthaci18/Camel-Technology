package org.ubt.clients.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.ubt.clients.product.dto.CartProductDTO;

import java.util.List;

@FeignClient("PRODUCT-SVC")
public interface ProductClient {
    @GetMapping(path="api/v1/product/getProductByCode/{productCode}")
    CartProductDTO getProductByCode(@PathVariable("productCode") String productCode);

    @GetMapping(path="api/v1/product/codes/{prodCodes}")
    List<String> getProductCodes(@PathVariable("prodCodes") List<String> prodCodes);

    // TODO CAREFUL SERVICE DISCOVER PRODUCT-SVCS
}
