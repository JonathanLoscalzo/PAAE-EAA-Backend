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

    @OneToMany(mappedBy = "venta")
    private Collection<VentaDetalle> detalles;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="facturas_formas_pago",
            joinColumns = @JoinColumn(name="VENTA_ID"),
            inverseJoinColumns = @JoinColumn(name="FORMA_PAGO_ID"))
    private Collection<FormaPago> formasPago;

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
}
