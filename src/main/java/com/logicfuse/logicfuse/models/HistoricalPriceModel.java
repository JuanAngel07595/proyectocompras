package com.logicfuse.logicfuse.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "historicalprices")
public class HistoricalPriceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer historico_precio_id;

    private Integer cod_producto;

    private double precio;

    private LocalDateTime fecha_modificacion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "historicoPrecio", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<SaleModel> ventas;

    public HistoricalPriceModel() {
    }


    public HistoricalPriceModel(Integer historico_precio_id, Integer cod_producto, double precio, LocalDateTime fecha_modificacion, List<SaleModel> ventas) {
        this.historico_precio_id = historico_precio_id;
        this.cod_producto = cod_producto;
        this.precio = precio;
        this.fecha_modificacion = fecha_modificacion;
        this.ventas = ventas;
    }

    public Integer getHistorico_precio_id() {
        return historico_precio_id;
    }

    public void setHistorico_precio_id(Integer historico_precio_id) {
        this.historico_precio_id = historico_precio_id;
    }

    public Integer getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(Integer cod_producto) {
        this.cod_producto = cod_producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDateTime getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(LocalDateTime fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public List<SaleModel> getVentas() {
        return ventas;
    }

    public void setVentas(List<SaleModel> ventas) {
        this.ventas = ventas;
    }
}
