package com.rest_spring_boot.converter.order;

import com.rest_spring_boot.converter.AbstractConverter;
import com.rest_spring_boot.converter.client.ClientConverter;
import com.rest_spring_boot.converter.product.ProductConverter;
import com.rest_spring_boot.dto.order.Order;
import com.rest_spring_boot.entity.order.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter extends AbstractConverter<OrderEntity, Order> {
    private ClientConverter clientConverter;
    private ProductConverter productConverter;

    @Autowired
    public void setClientConverter(ClientConverter clientConverter) {
        this.clientConverter = clientConverter;
    }

    @Autowired
    public void setProductConverter(ProductConverter productConverter) {
        this.productConverter = productConverter;
    }

    @Override
    public Order convert(OrderEntity orderEntity) {
        return new Order(orderEntity.getId(), orderEntity.getDateOrder(),
                clientConverter.convert(orderEntity.getClientEntity()),
                productConverter.convert(orderEntity.getProductEntity()));
    }

    @Override
    public OrderEntity convertReverse(Order order) {
        return new OrderEntity(order.getId(), order.getDateOrder(),
                clientConverter.convertReverse(order.getClient()),
                productConverter.convertReverse(order.getProduct()));
    }
}
