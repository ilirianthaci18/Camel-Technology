package org.ubt.product.common.mappers;

import org.modelmapper.ModelMapper;
import org.ubt.product.common.dto.BrandDTO;
import org.ubt.product.common.dto.BrandDTOProduct;
import org.ubt.product.model.Brand;

import static org.ubt.product.common.mappers.ProductMapper.toProductDTOBrand;

public class BrandMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static BrandDTO toBrandDTO(Brand brand) {
        BrandDTO brandDTO = modelMapper.map(brand, BrandDTO.class);

        brandDTO.setId(brand.getId());
        brandDTO.setName(brand.getName());
        brandDTO.setCategory(brand.getCategory());
        brandDTO.setFavorite(brand.isFavorite());
        brandDTO.setLogo(brand.getLogo());

        brand.getProductList().stream().forEach(product -> {
            brandDTO.getProducts().add(toProductDTOBrand(product));
        });

        return brandDTO;
    }

    public static BrandDTOProduct toBrandDTOProduct(Brand brand) {
        BrandDTOProduct brandDTOProduct = modelMapper.map(brand, BrandDTOProduct.class);

        brandDTOProduct.setCategory(brand.getCategory());
        brandDTOProduct.setName(brand.getName());

        return brandDTOProduct;
    }
}
