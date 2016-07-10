package ar.edu.uai.model.lote;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.producto.Producto;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LOTE")
@Access(AccessType.FIELD)
public class Lote extends Model<Integer> {
    @Id
    @GeneratedValue
    @Column(name = "LOTE_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "FECHA_VENCIMIENTO", nullable = false)
    private Date fechaVencimiento;

    @Column(name = "FECHA_ENTRADA", nullable = false)
    private Date fechaEntrada;

    @Column(name = "DETALLE", nullable = false)
    private String detalle;



    @Column(name = "UNIDADES_RESTANTES", nullable = false)
    private Integer unidadesRestantes;

    @Column(name = "UNIDADES_TOTALES", nullable = false)
    private Integer unidadesTotales;

    @ManyToOne
    @JoinColumn(name="PRODUCTO_ID")
    @JsonBackReference
    private Producto producto;

    public Lote() {
    }

    public Lote(Integer id,
                Date fechaVencimiento,
                Date fechaEntrada,
                String detalle,
                Producto producto,
                Integer unidadesRestantes,
                Integer unidadesTotales)
    {
        this.id = id;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaEntrada = fechaEntrada;
        this.detalle = detalle;
        this.producto = producto;
        this.unidadesRestantes = unidadesRestantes;
        this.unidadesTotales = unidadesTotales;
    }

    public void consumirUnidades( int cant)
    {
        unidadesRestantes -= cant;
        if(unidadesRestantes < 0) //Math.clamp quien te conoce
            unidadesRestantes = 0;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getDetalle() {
        return detalle;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }
    public  Date getFechaEntrada() {
        return fechaEntrada;
    }

    public  Producto getProducto() {
        return producto;
    }

    public Integer getUnidadesRestantes() {
        return unidadesRestantes;
    }
    public Integer getUnidadesTotales() {
        return unidadesTotales;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + id +
                                                 ", detalle=" + detalle +
                                                 ", fecha_entrada=" + fechaEntrada +
                                                 ", fecha_vencimiento= " + fechaVencimiento +"]";
    }
}
