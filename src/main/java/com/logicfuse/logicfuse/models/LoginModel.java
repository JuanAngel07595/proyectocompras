package com.logicfuse.logicfuse.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "login")

public class LoginModel {

    @Id
    private String email;  // Cambiar el identificador a correo electrónico

    @OneToOne
    @MapsId
    @JoinColumn(name = "email")
    private CustomerModel customer;

    public String getCorreo_electronico() {
        return email;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.email = correo_electronico;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public LoginModel(String correo_electronico, CustomerModel customer) {
        this.email = correo_electronico;
        this.customer = customer;
    }

    public LoginModel() {
    }
}