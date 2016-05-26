package ar.edu.uai.model.producto;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.ventaDetalle.VentaDetalle;
import ar.edu.uai.model.lote.Lote;
import ar.edu.uai.model.proveedor.Proveedor;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "PRODUCTO")
@Access(AccessType.FIELD)
public class Producto extends Model<Integer> {
    @Id
    @GeneratedValue
    @Column(name = "PRODUCTO_ID", unique = true, nullable = false)
    private Integer SKU;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "MINIMO", nullable = false)
    private Integer minimo;

    @Column(name = "CANTIDAD", nullable = false)
    private Integer cantidad;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="producto", cascade=CascadeType.ALL)
    @JsonManagedReference
    private Collection<Lote> lotes;


    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="PROVEEDOR_ID")
    private Proveedor proveedor;

    @OneToMany
    private Collection<VentaDetalle> lineasFactura;

    public Collection<Lote> getLotes()
    {
        return lotes;
    }

    public Producto() {
    }

    public Producto(Integer SKU, String nombre, Integer minimo, Integer cantidad, Proveedor proveedor) {
        this.SKU = SKU;
        this.nombre = nombre;
        this.minimo = minimo;
        this.cantidad = cantidad;
        this.proveedor = proveedor;
    }

    @Override
    public Integer getId() {
        return SKU;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getMinimo() {
        return minimo;
    }
    public  Integer getCantidad() {
        return cantidad;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + SKU +
                ", nombre=" + nombre +
                ", minimo=" + minimo +
                ", cantidad= " + cantidad +"]";
    }
}
