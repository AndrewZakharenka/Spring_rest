package com.rest_spring_boot.converter.product;

import com.rest_spring_boot.converter.AbstractConverter;
import com.rest_spring_boot.dto.product.Product;
import com.rest_spring_boot.entity.product.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter extends AbstractConverter<ProductEntity, Product> {
    @Override
    public Product convert(ProductEntity productEntity) {
        return new Product(productEntity.getId(), productEntity.getName(), productEntity.getPrice());
    }

    @Override
    public ProductEntity convertReverse(Product product) {
        return new ProductEntity(product.getId(), product.getName(), product.getPrice());
    }
}
