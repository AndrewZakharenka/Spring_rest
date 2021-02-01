package com.rest_spring_boot.entity.product;

import com.rest_spring_boot.entity.Entity;

import javax.persistence.Column;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "products")
public class ProductEntity extends Entity {

    @Column(name = "Name")
    private String name;

    @Column(name = "Price")
    private double price;

    public ProductEntity(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public ProductEntity(long id, String name, double price) {
        super(id);
        this.name = name;
        this.price = price;
    }

    public ProductEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
