package com.rest_spring_boot.dto.order;


import com.rest_spring_boot.dto.EntityDTO;
import com.rest_spring_boot.dto.client.Client;
import com.rest_spring_boot.dto.product.Product;

import java.util.Date;

public class Order extends EntityDTO {
    private Date dateOrder;
    private Client client;
    private Product product;

    public Order() {
    }

    public Order(long id, Date dateOrder, Client client, Product product) {
        super(id);
        this.dateOrder = dateOrder;
        this.client = client;
        this.product = product;
    }

    public Order(Date dateOrder, Client client, Product product) {
        this.dateOrder = dateOrder;
        this.client = client;
        this.product = product;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "dateOrder=" + dateOrder +
                ", clientEntity=" + client +
                ", productEntity=" + client +
                ", id=" + id +
                '}';
    }
}
