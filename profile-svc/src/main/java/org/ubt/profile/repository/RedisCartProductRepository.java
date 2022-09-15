package org.ubt.profile.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.ubt.clients.product.dto.CartProductDTO;

import java.util.List;

@Slf4j
@Repository
public class RedisCartProductRepository {

    private HashOperations hashOperations;

    private RedisTemplate redisTemplate;

    public RedisCartProductRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations=this.redisTemplate.opsForHash();
    }

    public void save(CartProductDTO cartProductDTO){
        log.info("Inside save method");
        hashOperations.put("cart-products",cartProductDTO.getCode(),cartProductDTO);
    }

    public List findAll(){
        return hashOperations.values("cart-products");
    }

    public void update(CartProductDTO cartProductDTO){
        save(cartProductDTO);
    }

    public void delete(String code){
        hashOperations.delete("cart-products",code);
    }
}
