package ar.edu.uai.model.formaPago;

import ar.edu.uai.model.Generics.Model;

import javax.persistence.*;

/**
 * Created by jloscalzo on 25/05/16.
 */
@Entity
@Table(name = "FORMAS_PAGO")
@Access(AccessType.FIELD)
public abstract class FormaPago extends Model {

    @Id
    @GeneratedValue
    @Column(name = "FORMA_PAGO_ID", unique = true, nullable = false)
    private Integer id;

    public FormaPago(String nombre, Boolean permiteDarCambio) {
        this.nombre = nombre;
        this.permiteDarCambio = permiteDarCambio;
    }

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="PERMITE_DAR_CAMBIO")
    private Boolean permiteDarCambio;

    public Boolean getPermiteDarCambio() {
        return permiteDarCambio;
    }

    @Override
    protected Object getId() {
        return null;
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


}
