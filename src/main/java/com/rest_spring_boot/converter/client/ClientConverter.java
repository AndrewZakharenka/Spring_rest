package com.rest_spring_boot.converter.client;

import com.rest_spring_boot.converter.AbstractConverter;
import com.rest_spring_boot.dto.client.Client;
import com.rest_spring_boot.entity.client.ClientEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter extends AbstractConverter<ClientEntity, Client> {

    @Override
    public Client convert(ClientEntity clientEntity) {
        return new Client(clientEntity.getId(), clientEntity.getName(), clientEntity.getSurname(),
                clientEntity.getPhone());
    }

    @Override
    public ClientEntity convertReverse(Client client) {
        return new ClientEntity(client.getId(), client.getName(), client.getSurname(),
                client.getPhone());
    }
}
