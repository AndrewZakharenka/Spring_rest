package com.rest_spring_boot.dto.client;


import com.rest_spring_boot.dto.EntityDTO;

public class Client extends EntityDTO {
    private String name;
    private String surname;
    private String phone;

    public Client(long id, String name, String surname, String phone) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public Client(String name, String surname, String phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public Client() {
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

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                '}';
    }
}
