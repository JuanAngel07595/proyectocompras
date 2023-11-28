package com.logicfuse.logicfuse.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
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
    private String correo_electronico;

    @Column(columnDefinition = "VARCHAR(255)")
    private String contrasena;

   @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
   @JsonIgnore
   private List<SaleModel> ventas;

    public CustomerModel() {
        // Establecer la fecha de registro al crear una nueva instancia
        this.fecha_registro = LocalDate.now();
    }

    public CustomerModel(String numero_documento, String tipo_documento, String nombres, String apellidos, String correo_electronico, String contrasena, List<SaleModel> ventas) {
        this.numero_documento = numero_documento;
        this.tipo_documento = tipo_documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha_registro = LocalDate.now(); // Establecer automáticamente la fecha de registro
        this.correo_electronico = correo_electronico;
        this.contrasena = contrasena;
        this.ventas = ventas;
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

    public List<SaleModel> getVentas() {
        return ventas;
    }

    public void setVentas(List<SaleModel> ventas) {
        this.ventas = ventas;
    }
}