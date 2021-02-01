package com.rest_spring_boot.service.impl.product;

import com.rest_spring_boot.converter.IConverter;
import com.rest_spring_boot.dto.product.Product;
import com.rest_spring_boot.entity.product.ProductEntity;
import com.rest_spring_boot.repository.product.ProductRepository;
import com.rest_spring_boot.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ProductServiceImpl implements Service<Product> {
    private ProductRepository productRepository;
    private IConverter<ProductEntity, Product> productConverter;


    @Override
    public List<Product> getAll() {
        return productConverter.convertAll(productRepository.findAll());
    }

    @Override
    public void add(Product product) {
        productRepository.save(productConverter.convertReverse(product)) ;
    }

    @Override
    public boolean deleteById(long id) {
        productRepository.deleteById(id);
        if (productRepository.getOne(id) == null){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public void edit(Product product) {
        productRepository.save(productConverter.convertReverse(product));
    }

    @Override
    public Product getById(long id) {
        return productConverter.convert(productRepository.findById(id).get());
    }


    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Autowired
    public void setProductConverter(IConverter<ProductEntity, Product> productConverter) {
        this.productConverter = productConverter;
    }
}
