package ar.edu.uai.model.lote;

import ar.edu.uai.model.Generics.Model;

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



    @ManyToOne
    @JoinColumn(name="PRODUCTO_ID")
    private Integer idProducto;

    public Lote() {
    }

    public Lote(Integer id, Date fechaVencimiento, Date fechaEntrada, String detalle) {
        this.id = id;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaEntrada = fechaEntrada;
        this.detalle = detalle;
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


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + id +
                                                 ", detalle=" + detalle +
                                                 ", fecha_entrada=" + fechaEntrada +
                                                 ", fecha_vencimiento= " + fechaVencimiento +"]";
    }
}
