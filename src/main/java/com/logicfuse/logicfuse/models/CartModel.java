package com.logicfuse.logicfuse.models;


import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "cart")
public class CartModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer carrito_id;


    private Integer cantidad;

    private Double precio;

    private Double subtotal;

    private LocalDateTime fecha_agregado;

     //@ManyToOne
     //private EmployeeModel empleados;

     @ManyToOne
     @JoinColumn(name = "producto_id")
     private ProductModel productos;

    public CartModel(Integer carrito_id, Integer cantidad, Double precio, Double subtotal, LocalDateTime fecha_agregado, EmployeeModel empleados, ProductModel productos) {
        this.carrito_id = carrito_id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
        this.fecha_agregado = fecha_agregado;
       //  this.empleados = empleados;
        this.productos = productos;
    }

    public CartModel() {
    }

    public void setCarrito_id(Integer carrito_id) {
        this.carrito_id = carrito_id;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public void setFecha_agregado(LocalDateTime fecha_agregado) {
        this.fecha_agregado = fecha_agregado;
    }

   // public void setEmpleados(EmployeeModel empleados) {
     //   this.empleados = empleados;
    //}

    public void setProductos(ProductModel productos) {
        this.productos = productos;
    }

    public Integer getCarrito_id() {
        return carrito_id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public LocalDateTime getFecha_agregado() {
        return fecha_agregado;
    }

    //public EmployeeModel getEmpleados() {
      //  return empleados;
    //}

    public ProductModel getProductos() {
        return productos;
    }
}

