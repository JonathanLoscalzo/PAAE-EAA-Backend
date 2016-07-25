package ar.edu.uai.model.producto;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.ventaDetalle.VentaDetalle;
import ar.edu.uai.model.lote.Lote;
import ar.edu.uai.model.proveedor.Proveedor;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.xml.bind.ValidationException;
import java.util.ArrayList;
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

    public int getTotalUnits()
    {
        int units = 0;
        for(Lote l : lotes)
        {
            units+= l.getUnidadesTotales();
        }
        return units;
    }

    public int getCurrentUnits()
    {
        int units = 0;


        for(Lote l : lotes)
        {
            units+= l.getUnidadesRestantes();
        }
        return units;
    }

    public void discount(int cantidad) throws ValidationException {
        Integer current = this.getCurrentUnits();

        if (current <= cantidad) throw new ValidationException("No hay suficiente stock");

        Integer restante = cantidad;

        for (Lote lote : this.getLotes()) {
            int unidadesRestantes = lote.getUnidadesRestantes();
            if (unidadesRestantes >= restante) {
                lote.consumirUnidades(restante);
                cantidad = 0;
                break;
            } else {
                if (unidadesRestantes < restante) {
                    restante -= unidadesRestantes;
                    lote.consumirUnidades(unidadesRestantes);
                }
            }
        }
    }

    public boolean porAgotarse()
    {
        if(getCurrentUnits() < minimo)
            return true;

        return false;
    }
    public Producto() {
    }

    public Producto(Integer SKU, String nombre, Integer minimo, Proveedor proveedor) {
        this.SKU = SKU;
        this.nombre = nombre;
        this.minimo = minimo;
        this.proveedor = proveedor;
        lotes = new ArrayList<>();
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

    public Proveedor getProveedor() {
        return proveedor;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + SKU +
                ", nombre=" + nombre +
                ", minimo=" + minimo +
                ", cantidad= " +"]";
    }
}
