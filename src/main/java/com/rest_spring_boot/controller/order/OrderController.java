package com.rest_spring_boot.controller.order;

import com.rest_spring_boot.dto.IEntityDTO;
import com.rest_spring_boot.dto.order.Order;
import com.rest_spring_boot.service.Service;
import com.rest_spring_boot.service.impl.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private Service service;

    @Autowired
    public void setService(OrderServiceImpl service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        final List<Order> orders = service.getAll();

        return orders != null &&  !orders.isEmpty()
                ? new ResponseEntity<>(orders, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> read(@PathVariable(name = "id") int id) {
        final Order order = (Order)service.getById(id);
        return order != null
                ? new ResponseEntity<>(order, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        service.add(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Order> update(@RequestBody Order order) {
        service.edit(order);
        return order != null
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        final boolean deleted = service.deleteById(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
