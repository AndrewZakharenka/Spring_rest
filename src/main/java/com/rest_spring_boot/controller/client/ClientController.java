package com.rest_spring_boot.controller.client;

import com.rest_spring_boot.dto.client.Client;
import com.rest_spring_boot.service.Service;
import com.rest_spring_boot.service.impl.client.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private Service service;

    @Autowired
    public void setService(ClientServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllOrders() {
        final List<Client> clients = service.getAll();

        return clients != null && !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> read(@PathVariable(name = "id") int id) {
        final Client client = (Client) service.getById(id);
        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Client> createOrder(@RequestBody Client client) {
        service.add(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Client> update(@RequestBody Client client) {
        service.edit(client);
        return client != null
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
