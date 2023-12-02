package com.logicfuse.logicfuse.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "logins")

public class LoginModel {

    private String correo_electronico;  // Cambiar el identificador a correo electrónico

    @OneToOne
    @MapsId
    @JoinColumn(name = "correo_electronico")
    private CustomerModel customer;

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public LoginModel(String correo_electronico, CustomerModel customer) {
        this.correo_electronico = correo_electronico;
        this.customer = customer;
    }

    public LoginModel() {
    }
}