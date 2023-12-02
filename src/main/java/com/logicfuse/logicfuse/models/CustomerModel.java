package com.logicfuse.logicfuse.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customers")
public class CustomerModel {

    @Id
    @Column(unique = true)
    private String numero_documento;

    @Column(columnDefinition = "VARCHAR(2)")
    private String tipo_documento;

    @Column(columnDefinition = "VARCHAR(100)")
    private String nombres;

    @Column(columnDefinition = "VARCHAR(100)")
    private String apellidos;

    private LocalDate fecha_registro;

    @Column(columnDefinition = "VARCHAR(100)")
    private String email;
    @Column(columnDefinition = "VARCHAR(255)")
    private String contrasena;

    @Column(columnDefinition = "BOOLEAN")  // Campo para representar los términos
    private boolean terminos;

    @Column(columnDefinition = "BOOLEAN")  // Campo para representar el boletín
    private boolean boletin;

    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
    //@JsonIgnore
    //private List<SaleModel> ventas;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private LoginModel login;

    // Otros campos

    public CustomerModel() {
        // Establecer la fecha de registro al crear una nueva instancia
        this.fecha_registro = LocalDate.now();
    }
    public CustomerModel(String numero_documento, String tipo_documento, String nombres, String apellidos, String email, boolean terminos, boolean boletin) {
        this.numero_documento = numero_documento;
        this.tipo_documento = tipo_documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha_registro = LocalDate.now(); // Establecer automáticamente la fecha de registro
        this.email = email;
        this.contrasena = contrasena;
       // this.ventas = ventas;
        this.terminos = terminos;
        this.boletin = boletin;

        // Crear instancia de LoginModel y establecer la relación bidireccional
        LoginModel login = new LoginModel();
        login.setCorreo_electronico(email);
        login.setCustomer(this);
        this.login = login;
    }


    // Getters y Setters

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isTerminos() {
        return terminos;
    }

    public void setTerminos(boolean terminos) {
        this.terminos = terminos;
    }

    public boolean isBoletin() {
        return boletin;
    }

    public void setBoletin(boolean boletin) {
        this.boletin = boletin;
    }


    public LoginModel getLogin() {
        return login;
    }

    public void setLogin(LoginModel login) {
        this.login = login;
    }
}