package com.logicfuse.logicfuse.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "category")
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer categoria_id;

    private String nombre;

    private String descripcion;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "categoria")
    @JsonIgnore
    private List<ProductModel> productos;

    public CategoryModel() {

    }

    public CategoryModel(Integer categoria_id, String nombre, String descripcion, List<ProductModel> productos) {
        this.categoria_id = categoria_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.productos = productos;
    }

    public Integer getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Integer categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<ProductModel> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductModel> productos) {
        this.productos = productos;
    }
}
