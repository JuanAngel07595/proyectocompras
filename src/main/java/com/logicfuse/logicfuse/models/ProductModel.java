package com.logicfuse.logicfuse.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    //Utilizar si se desea cambiar el nombre de el atributo + especificación de el varchar
    private Integer producto_id;

    @Column(unique = true, columnDefinition = "VARCHAR(255)")
    private Integer cod_producto;

    @Column(columnDefinition = "VARCHAR(255)")
    private String nombre_producto;

    private String descripcion;

    private Double precio;

    @Column(columnDefinition = "VARCHAR(100)")
    private String marca;

    @Column(columnDefinition = "VARCHAR(50)")
    private String color;

    private String talla;

    private Integer stock;

    @Column(columnDefinition = "VARCHAR(255)")
    private String imagen_url;

    @ManyToOne
    private CategoryModel categoria;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productos", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CartModel> carritos;


    public ProductModel() {

    }


    public ProductModel(Integer producto_id, Integer cod_producto, String nombre_producto, String descripcion, Double precio, String marca, String color, String talla, Integer stock, String imagen_url, CategoryModel categoria, List<CartModel> carritos) {
        this.producto_id = producto_id;
        this.cod_producto = cod_producto;
        this.nombre_producto = nombre_producto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.marca = marca;
        this.color = color;
        this.talla = talla;
        this.stock = stock;
        this.imagen_url = imagen_url;
        this.categoria = categoria;
        this.carritos = carritos;
    }

    public Integer getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Integer producto_id) {
        this.producto_id = producto_id;
    }

    public Integer getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(Integer cod_producto) {
        this.cod_producto = cod_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImagen_url() {
        return imagen_url;
    }

    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
    }

    public CategoryModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoryModel categoria) {
        this.categoria = categoria;
    }

    public List<CartModel> getCarritos() {
        return carritos;
    }

    public void setCarritos(List<CartModel> carritos) {
        this.carritos = carritos;
    }
}