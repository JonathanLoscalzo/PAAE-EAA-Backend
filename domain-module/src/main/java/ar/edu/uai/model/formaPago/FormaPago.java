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

    @Override
    protected Object getId() {
        return null;
    }
}
