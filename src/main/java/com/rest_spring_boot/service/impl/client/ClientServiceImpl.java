package com.rest_spring_boot.service.impl.client;

import com.rest_spring_boot.converter.IConverter;
import com.rest_spring_boot.dto.client.Client;
import com.rest_spring_boot.entity.client.ClientEntity;
import com.rest_spring_boot.repository.client.ClientRepository;
import com.rest_spring_boot.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ClientServiceImpl implements Service<Client> {
    private ClientRepository clientRepository;
    private IConverter<ClientEntity, Client> clientConverter;


    @Override
    public List<Client> getAll() {
        return clientConverter.convertAll(clientRepository.findAll());
    }

    @Override
    public void add(Client client) {
        clientRepository.save(clientConverter.convertReverse(client)) ;
    }

    @Override
    public boolean deleteById(long id) {
        clientRepository.deleteById(id);
        if (clientRepository.getOne(id) == null){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public void edit(Client client) {
        clientRepository.save(clientConverter.convertReverse(client));
    }

    @Override
    public Client getById(long id) {
        return clientConverter.convert(clientRepository.findById(id).get());
    }


    @Autowired
    public void setProductRepository(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Autowired
    public void setClientConverter(IConverter<ClientEntity, Client> clientConverter) {
        this.clientConverter = clientConverter;
    }
}
