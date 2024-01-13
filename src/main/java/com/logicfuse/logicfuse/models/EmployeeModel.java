package com.logicfuse.logicfuse.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employees")
public class EmployeeModel {
    @Id
    @Column(unique = true)
    private String  numero_documento;

    @Column(columnDefinition = "VARCHAR(2)")
    private String tipo_documento;
    @Column(columnDefinition = "VARCHAR(100)")
    private String nombres;

    @Column(columnDefinition = "VARCHAR(100)")
    private String apellidos;

    @Column(columnDefinition = "VARCHAR(50)")
    private String cargo;

    private LocalDateTime fecha_registro;

    @Column(columnDefinition = "VARCHAR(100)")
    private String email;

    @Column(columnDefinition = "VARCHAR(255)")
    private String contrasena;

    @Column(columnDefinition = "VARCHAR(255)")
    private String token;

    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "employee_roles", joinColumns = @JoinColumn(name = "email"))
    @Column(name = "role")
    private Set<String> roles = new HashSet<>();


   // @OneToMany(fetch = FetchType.LAZY, mappedBy = "empleados", cascade = CascadeType.ALL)
    //@JsonIgnore
    //private List<CartModel> carritos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email", referencedColumnName = "email")
    private LoginModel login;


    public EmployeeModel() {

    }

    public EmployeeModel(Set<String> roles, LoginModel login) {
        this.roles = roles;
        this.login = login;
    }

    public EmployeeModel(String numero_documento, String tipo_documento, String nombres, String apellidos, String cargo, LocalDateTime fecha_registro, String email, String contrasena, String token, List<CartModel> carritos) {
        this.numero_documento = numero_documento;
        this.tipo_documento = tipo_documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.fecha_registro = fecha_registro;
        this.email = email;
        this.contrasena = contrasena;
       // this.carritos = carritos;
        this.token = token;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
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

   // public List<CartModel> getCarritos() {
   //     return carritos;
   // }
    public LoginModel getLogin() {
        return login;
    }

    public void setLogin(LoginModel login) {
        this.login = login;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    //public void setCarritos(List<CartModel> carritos) {
    //    this.carritos = carritos;


    //}
}