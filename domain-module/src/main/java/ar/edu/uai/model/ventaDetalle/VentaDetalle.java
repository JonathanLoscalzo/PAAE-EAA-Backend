package ar.edu.uai.model.ventaDetalle;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.venta.Venta;
import ar.edu.uai.model.producto.Producto;

import javax.persistence.*;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "VENTA_DETALLE")
@Access(AccessType.FIELD)
public class VentaDetalle extends Model {

    public VentaDetalle() {
    }
    public VentaDetalle(Integer fila, Integer cantidad, Double precio, Producto producto, Venta venta){
        setPrecio(precio);
        setProducto(producto);
        setFila(fila);
        setVenta(venta);
    }

    @Id
    @GeneratedValue
    @Column(name = "LINEA_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name="FILA")
    private Integer fila;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Venta venta;

    @Column(name="CANTIDAD")
    private Integer cantidad;

    @Column(name= "PRECIO")
    private Double precio;

    @Override
    protected Object getId() {
        return this.id;
    }

    public Integer getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
