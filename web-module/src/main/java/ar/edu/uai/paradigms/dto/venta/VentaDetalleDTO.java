package ar.edu.uai.paradigms.dto.venta;

import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.dto.producto.ProductoDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jloscalzo on 26/05/16.
 */
public class VentaDetalleDTO implements DTO<Integer> {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("fila")
    private Integer fila;

    @JsonProperty("producto")
    private ProductoDTO producto;

    @JsonProperty("venta")
    private VentaDTO venta;

    @JsonProperty("cantidad")
    private Integer cantidad;

    @JsonProperty("precio")
    private Double precio;

    @JsonCreator
    public VentaDetalleDTO(@JsonProperty("id") Integer id,
                           @JsonProperty("fila") Integer fila,
                           @JsonProperty("producto") ProductoDTO producto,
                           @JsonProperty("cantidad") Integer cantidad,
                           @JsonProperty("precio") Double precio) {
        this.id = id;
        this.fila = fila;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFila() {
        return fila;
    }

    public void setFila(Integer fila) {
        this.fila = fila;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public VentaDTO getVenta() {
        return venta;
    }

    public void setVenta(VentaDTO venta) {
        this.venta = venta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
