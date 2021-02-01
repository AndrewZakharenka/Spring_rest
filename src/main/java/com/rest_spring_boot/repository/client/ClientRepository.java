package com.rest_spring_boot.repository.client;

import com.rest_spring_boot.entity.client.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

}
