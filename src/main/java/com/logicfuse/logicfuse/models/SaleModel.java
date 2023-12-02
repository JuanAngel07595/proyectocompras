package com.logicfuse.logicfuse.models;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
public class SaleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id_venta;

    private Integer cantidad;

    private Double subtotal;

    private LocalDateTime fecha_venta;

    @Column(columnDefinition = "VARCHAR(255)")
    private String direccion_entrega;

    // @ManyToOne
    //private CustomerModel cliente;

    @ManyToOne
    @JoinColumn(name = "historico_precio_id")
    private HistoricalPriceModel historicoPrecio;

    public SaleModel() {

    }

    public SaleModel(Integer id_venta, Integer cantidad, Double subtotal, LocalDateTime fecha_venta, String direccion_entrega, HistoricalPriceModel historicoPrecio) {
        this.id_venta = id_venta;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.fecha_venta = fecha_venta;
        this.direccion_entrega = direccion_entrega;
      //  this.cliente = cliente;
        this.historicoPrecio = historicoPrecio;
    }

    public Integer getId_venta() {
        return id_venta;
    }

    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public LocalDateTime getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(LocalDateTime fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getDireccion_entrega() {
        return direccion_entrega;
    }

    public void setDireccion_entrega(String direccion_entrega) {
        this.direccion_entrega = direccion_entrega;
    }

   // public CustomerModel getCliente() {
  //      return cliente;
    //}

    //public void setCliente(CustomerModel cliente) {
     //   this.cliente = cliente;
   // }

    public HistoricalPriceModel getHistoricoPrecio() {
        return historicoPrecio;
    }

    public void setHistoricoPrecio(HistoricalPriceModel historicoPrecio) {
        this.historicoPrecio = historicoPrecio;
    }
}
