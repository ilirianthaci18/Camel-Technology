package org.ubt.profile.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.ubt.clients.product.ProductClient;
import org.ubt.clients.product.dto.CartProductDTO;
import org.ubt.profile.repository.RedisCartProductRepository;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class CartServiceImpl implements CartService{

    private final RestTemplate restTemplate;
    private final ProductClient productClient;
    private RedisCartProductRepository repository;

//    @CachePut(key = "cart-products",value = "CartProduct")
    @Override
    public void addProductToCart(String productCode) {
//        CartProductDTO cartProductDTO=restTemplate.getForObject(
//                "http://localhost:8082/api/v1/product/getProductByCode/{productCode}",CartProductDTO.class,productCode);

        CartProductDTO cartProductDTO = productClient.getProductByCode(productCode);

        log.info(cartProductDTO.toString());
        repository.save(cartProductDTO);
    }

    @Override
    public List<CartProductDTO> saveProductToCart(CartProductDTO cartProductDTO) {
        return null;
    }

//    @Cacheable(key="#cart-products",value = "CartProduct")
    public List<CartProductDTO> getCartProducts() {
        return repository.findAll();
    }
}
