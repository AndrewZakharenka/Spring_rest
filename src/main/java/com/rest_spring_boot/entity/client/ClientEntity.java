package com.rest_spring_boot.entity.client;

import com.rest_spring_boot.entity.Entity;

import javax.persistence.Column;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "clients")
public class ClientEntity extends Entity {

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Phone")
    private String phone;

    public ClientEntity(long id, String name, String surname, String phone) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public ClientEntity(String name, String surname, String phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public ClientEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
