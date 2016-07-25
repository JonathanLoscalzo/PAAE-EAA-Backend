package ar.edu.uai.model.venta;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.formaPago.FormaPago;

import javax.persistence.*;

/**
 * Created by jloscalzo on 12/06/16.
 */
@Entity
@Table(name="VENTA_FORMAPAGO")
@Access(AccessType.FIELD)
public class VentaFormaPago extends Model<Integer> {
    @Column(name = "CANTIDAD")
    private Double cantidad;

    @ManyToOne()
    @JoinColumn(name="FORMA_PAGO_ID")
    private FormaPago formaPago;

    @ManyToOne
    @JoinColumn(name="VENTA_ID")
    private Venta venta;

    @Id
    @GeneratedValue
    @Column(name = "VENTA_FORMAPAGO_ID", unique = true, nullable = false)
    private Integer id;

    public VentaFormaPago(Double cantidad, FormaPago formaPago) {
        this.cantidad = cantidad;
        this.formaPago = formaPago;
    }

    public VentaFormaPago() {
    }

    public VentaFormaPago(Venta venta, FormaPago formapago, Double cantidad) {
        this.venta = venta;
        this.formaPago = formapago;
        this.cantidad = cantidad;
    }



    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public Integer getId() {
        return null;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
