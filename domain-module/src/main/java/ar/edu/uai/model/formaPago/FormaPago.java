package ar.edu.uai.model.formaPago;

import ar.edu.uai.model.Generics.Model;

import javax.persistence.*;

/**
 * Created by jloscalzo on 25/05/16.
 */
@Entity
@Table(name = "FORMAS_PAGO")
@Access(AccessType.FIELD)
public class FormaPago extends Model<Integer> {

    @Id
    @GeneratedValue
    @Column(name = "FORMA_PAGO_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "PERMITE_DAR_CAMBIO")
    private Boolean permiteDarCambio;

    /*@OneToMany() // TODO: que tipo de cascada?
    private Collection<VentaFormaPago> ventaFormasPago;*/

    public FormaPago(String nombre, Boolean permiteDarCambio) {
        this.nombre = nombre;
        this.permiteDarCambio = permiteDarCambio;
    }

    public FormaPago() {

    }

    public Boolean getPermiteDarCambio() {
        return permiteDarCambio;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setPermiteDarCambio(Boolean permiteDarCambio) {
        this.permiteDarCambio = permiteDarCambio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    /*public Collection<VentaFormaPago> getVentaFormasPago() {
        return ventaFormasPago;
    }

    public void setVentaFormasPago(Collection<VentaFormaPago> ventaFormasPago) {
        this.ventaFormasPago = ventaFormasPago;
    }*/
}
