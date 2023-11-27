package com.logicfuse.logicfuse.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    @Column(columnDefinition = "VARCHAR(20)")
    private String rol;

    private LocalDateTime fecha_registro;

    @Column(columnDefinition = "VARCHAR(100)")
    private String correo_electronico;

    @Column(columnDefinition = "VARCHAR(255)")
    private String contrasena;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "empleados", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CartModel> carritos;

    public EmployeeModel() {

    }

    public EmployeeModel(String numero_documento, String tipo_documento, String nombres, String apellidos, String cargo, String rol, LocalDateTime fecha_registro, String correo_electronico, String contrasena, List<CartModel> carritos) {
        this.numero_documento = numero_documento;
        this.tipo_documento = tipo_documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.rol = rol;
        this.fecha_registro = fecha_registro;
        this.correo_electronico = correo_electronico;
        this.contrasena = contrasena;
        this.carritos = carritos;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<CartModel> getCarritos() {
        return carritos;
    }

    public void setCarritos(List<CartModel> carritos) {
        this.carritos = carritos;
    }
}