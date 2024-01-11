package com.logicfuse.logicfuse.models;

import javax.persistence.*;
import java.time.LocalDate;


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

    @Column (columnDefinition = "VARCHAR(255)")
    private String rol;

    @Column(columnDefinition = "VARCHAR(255)")
    private String token;



    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
    //@JsonIgnore
    //private List<SaleModel> ventas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email", referencedColumnName = "email", insertable = false, updatable = false)
    private LoginModel login;


    // Otros campos

    public CustomerModel() {
        // Establecer la fecha de registro al crear una nueva instancia
        this.fecha_registro = LocalDate.now();
    }
    public CustomerModel(String numero_documento, String tipo_documento, String nombres, String contrasena, String apellidos, String email,String rol, String token, boolean terminos, boolean boletin) {
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
        this.rol = rol;
        this.token = token;

        LoginModel login = new LoginModel(email, this);
        this.login = login;

    }




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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
