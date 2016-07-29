package ar.edu.uai.paradigms.dto.venta;

import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.dto.producto.ProductoDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jloscalzo on 26/05/16.
 */
public class VentaDetalleDTO implements DTO<Integer> {
    private Integer id;

    private Integer fila;

    @JsonProperty("producto")
    private ProductoDTO producto;

    private VentaDTO venta;

    private Integer cantidad;

    private Double precio;

    @JsonCreator
    public VentaDetalleDTO(@JsonProperty("id") Integer id,
                           @JsonProperty("fila") Integer fila,
                           @JsonProperty("product_id") Integer productoId,
                           @JsonProperty("sale_id") Integer saleId,
                           @JsonProperty("cantidad") Integer cantidad,
                           @JsonProperty("precio") Double precio) {
        this.id = id;
        this.fila = fila;
        this.producto = new ProductoDTO(productoId, null, null, null, null);
        this.venta = new VentaDTO(saleId, null, null, Math.toIntExact(0), null, null, null);
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public VentaDetalleDTO(Integer id, Integer fila, ProductoDTO productoDTO, Integer cantidad, Double precio) {
        this.id = id;
        this.fila = fila;
        this.producto = productoDTO;
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
