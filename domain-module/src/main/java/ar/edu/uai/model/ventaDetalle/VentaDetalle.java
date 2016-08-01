package ar.edu.uai.model.ventaDetalle;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.producto.Producto;
import ar.edu.uai.model.venta.Venta;

import javax.persistence.*;

@Entity
@Table(name = "VENTA_DETALLE")
@Access(AccessType.FIELD)
public class VentaDetalle extends Model<Integer> {

    public VentaDetalle() {
    }

    public VentaDetalle(Integer fila, Integer cantidad, Double precio, Producto producto, Venta venta) {
        setPrecio(precio);
        setProducto(producto);
        setFila(fila);
        setVenta(venta);
        setCantidad(cantidad);
    }

    @Id
    @GeneratedValue
    @Column(name = "LINEA_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "FILA")
    private Integer fila;

    @ManyToOne //TODO: ver el cascade type
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "VENTA_ID")
    private Venta venta;

    @Column(name = "CANTIDAD")
    private Integer cantidad;

    @Column(name = "PRECIO")
    private Double precio;

    @Override
    public Integer getId() {
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

    public Integer getProductoId() {
        return getProducto().getId();
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

    public void setId(Integer id) {
        this.id = id;
    }
}
