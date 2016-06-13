package ar.edu.uai.model.venta;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.formaPago.FormaPago;
import ar.edu.uai.model.ventaDetalle.VentaDetalle;
import ar.edu.uai.model.cliente.Cliente;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "VENTA")
@Access(AccessType.FIELD)
public class Venta extends Model {
//TODO Falta vendedor
    public Venta() {

    }

    public Venta(int nro, Cliente cliente, Date fecha){
        setCliente(cliente);
        setFecha(fecha);
        setNro(nro);
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Id
    @GeneratedValue
    @Column(name = "VENTA_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "FECHA")
    private Date fecha;

    @Column(name = "NRO_FACTURA")
    private int nro;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<VentaDetalle> detalles;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<VentaFormaPago> ventaFormasPago;

    public void setDetalles(Collection detalles) {
        this.detalles = detalles;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<VentaDetalle> getDetalles() {
        return detalles;
    }

    public Collection<VentaFormaPago> getVentaFormasPago() {
        return ventaFormasPago;
    }

    public void setVentaFormasPago(Collection<VentaFormaPago> ventaFormasPago) {
        this.ventaFormasPago = ventaFormasPago;
    }
}
