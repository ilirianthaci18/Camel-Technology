package org.ubt.product.common.mappers;

import org.modelmapper.ModelMapper;
import org.ubt.clients.product.dto.CartProductDTO;
import org.ubt.product.common.dto.*;
import org.ubt.product.model.Product;

import static org.ubt.product.common.mappers.BrandMapper.toBrandDTOProduct;
import static org.ubt.product.common.mappers.InventoryMapper.toInventoryDTOProduct;
import static org.ubt.product.common.mappers.OrderTakingMapper.toOrderTakingDTOProduct;
import static org.ubt.product.common.mappers.WareHouseMapper.toInventoryDTOWareHouse;

public class ProductMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static CartProductDTO toCartProductDTO(Product product) {
        CartProductDTO cartProductDTO = modelMapper.map(product, CartProductDTO.class);

//        cartProductDTO.setCode(product.getCode());
//        cartProductDTO.setPrice(product.getPrice());
//        cartProductDTO.setMainImage(product.getMainImage());
//        cartProductDTO.setName(product.getName());

        return cartProductDTO;
    }

    public static ProductDTO toProductDTO(Product product) {
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);

        productDTO.setId(product.getId());
        productDTO.setCode(product.getCode());
        productDTO.setBattery(product.getBattery());
        productDTO.setCategory(product.getCategory());
        productDTO.setAvailability(product.getAvailability());
        productDTO.setAvgRating(product.getAvgRating());
        productDTO.setColor(product.getColor());
        productDTO.setCreatedTime(product.getCreatedTime());
        productDTO.setDiscountPercentage(product.getDiscountPercentage());
        productDTO.setEnabled(product.isEnabled());
        productDTO.setFavorite(product.isFavorite());
        productDTO.setFullDescription(product.getFullDescription());
        productDTO.setHeight(product.getHeight());
        productDTO.setInStock(product.isInStock());
        productDTO.setLength(product.getLength());
        productDTO.setMainImage(product.getMainImage());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setShortDescription(product.getShortDescription());
        productDTO.setWeight(product.getWeight());
        productDTO.setWidth(product.getWidth());
        productDTO.setInventory(toInventoryDTOProduct(product.getInventory()));
        productDTO.setWareHouse(toInventoryDTOWareHouse(product.getWareHouse()));
        productDTO.setBrand(toBrandDTOProduct(product.getBrand()));
        productDTO.setOrderTaking(toOrderTakingDTOProduct(product.getOrderTaking()));

        return productDTO;
    }

    public static ProductDTOInventory toProductDTOInventory(Product product) {
        ProductDTOInventory productDTOInventory = modelMapper.map(product, ProductDTOInventory.class);

        productDTOInventory.setCode(product.getCode());
        productDTOInventory.setBattery(product.getBattery());
        productDTOInventory.setCategory(product.getCategory());
        productDTOInventory.setAvailability(product.getAvailability());
        productDTOInventory.setAvgRating(product.getAvgRating());
        productDTOInventory.setColor(product.getColor());
        productDTOInventory.setCreatedTime(product.getCreatedTime());
        productDTOInventory.setDiscountPercentage(product.getDiscountPercentage());
        productDTOInventory.setEnabled(product.isEnabled());
        productDTOInventory.setFavorite(product.isFavorite());
        productDTOInventory.setFullDescription(product.getFullDescription());
        productDTOInventory.setHeight(product.getHeight());
        productDTOInventory.setInStock(product.isInStock());
        productDTOInventory.setLength(product.getLength());
        productDTOInventory.setMainImage(product.getMainImage());
        productDTOInventory.setName(product.getName());
        productDTOInventory.setPrice(product.getPrice());
        productDTOInventory.setShortDescription(product.getShortDescription());
        productDTOInventory.setWeight(product.getWeight());
        productDTOInventory.setWidth(product.getWidth());

        return productDTOInventory;
    }

    public static ProductDTOWareHouse toProductDTOWareHouse(Product product) {
        ProductDTOWareHouse productDTOWareHouse = modelMapper.map(product, ProductDTOWareHouse.class);

        productDTOWareHouse.setCode(product.getCode());
        productDTOWareHouse.setBattery(product.getBattery());
        productDTOWareHouse.setCategory(product.getCategory());
        productDTOWareHouse.setAvailability(product.getAvailability());
        productDTOWareHouse.setAvgRating(product.getAvgRating());
        productDTOWareHouse.setColor(product.getColor());
        productDTOWareHouse.setCreatedTime(product.getCreatedTime());
        productDTOWareHouse.setDiscountPercentage(product.getDiscountPercentage());
        productDTOWareHouse.setEnabled(product.isEnabled());
        productDTOWareHouse.setFavorite(product.isFavorite());
        productDTOWareHouse.setFullDescription(product.getFullDescription());
        productDTOWareHouse.setHeight(product.getHeight());
        productDTOWareHouse.setInStock(product.isInStock());
        productDTOWareHouse.setLength(product.getLength());
        productDTOWareHouse.setMainImage(product.getMainImage());
        productDTOWareHouse.setName(product.getName());
        productDTOWareHouse.setPrice(product.getPrice());
        productDTOWareHouse.setShortDescription(product.getShortDescription());
        productDTOWareHouse.setWeight(product.getWeight());
        productDTOWareHouse.setWidth(product.getWidth());

        return productDTOWareHouse;
    }

    public static ProductDTOBrand toProductDTOBrand(Product product) {
        ProductDTOBrand productDTOBrand = modelMapper.map(product, ProductDTOBrand.class);

        productDTOBrand.setCode(product.getCode());
        productDTOBrand.setBattery(product.getBattery());
        productDTOBrand.setCategory(product.getCategory());
        productDTOBrand.setAvailability(product.getAvailability());
        productDTOBrand.setAvgRating(product.getAvgRating());
        productDTOBrand.setColor(product.getColor());
        productDTOBrand.setCreatedTime(product.getCreatedTime());
        productDTOBrand.setDiscountPercentage(product.getDiscountPercentage());
        productDTOBrand.setEnabled(product.isEnabled());
        productDTOBrand.setFavorite(product.isFavorite());
        productDTOBrand.setFullDescription(product.getFullDescription());
        productDTOBrand.setHeight(product.getHeight());
        productDTOBrand.setInStock(product.isInStock());
        productDTOBrand.setLength(product.getLength());
        productDTOBrand.setMainImage(product.getMainImage());
        productDTOBrand.setName(product.getName());
        productDTOBrand.setPrice(product.getPrice());
        productDTOBrand.setShortDescription(product.getShortDescription());
        productDTOBrand.setWeight(product.getWeight());
        productDTOBrand.setWidth(product.getWidth());

        return productDTOBrand;
    }

    public static ProductDTOOrderTaking toProductDTOOrderTaking(Product product) {
        ProductDTOOrderTaking productDTOOrderTaking = modelMapper.map(product, ProductDTOOrderTaking.class);

        productDTOOrderTaking.setCode(product.getCode());
        productDTOOrderTaking.setBattery(product.getBattery());
        productDTOOrderTaking.setCategory(product.getCategory());
        productDTOOrderTaking.setAvailability(product.getAvailability());
        productDTOOrderTaking.setAvgRating(product.getAvgRating());
        productDTOOrderTaking.setColor(product.getColor());
        productDTOOrderTaking.setCreatedTime(product.getCreatedTime());
        productDTOOrderTaking.setDiscountPercentage(product.getDiscountPercentage());
        productDTOOrderTaking.setEnabled(product.isEnabled());
        productDTOOrderTaking.setFavorite(product.isFavorite());
        productDTOOrderTaking.setFullDescription(product.getFullDescription());
        productDTOOrderTaking.setHeight(product.getHeight());
        productDTOOrderTaking.setInStock(product.isInStock());
        productDTOOrderTaking.setLength(product.getLength());
        productDTOOrderTaking.setMainImage(product.getMainImage());
        productDTOOrderTaking.setName(product.getName());
        productDTOOrderTaking.setPrice(product.getPrice());
        productDTOOrderTaking.setShortDescription(product.getShortDescription());
        productDTOOrderTaking.setWeight(product.getWeight());
        productDTOOrderTaking.setWidth(product.getWidth());

        return productDTOOrderTaking;
    }

}
