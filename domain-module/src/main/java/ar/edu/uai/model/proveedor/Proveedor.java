package ar.edu.uai.model.proveedor;

import ar.edu.uai.model.Generics.Model;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Skeith on 19/05/2016.
 */

@Entity
@Table(name = "PROVEEDOR")
@Access(AccessType.FIELD)
public class Proveedor extends Model<Integer> {
    @Id
    @GeneratedValue
    @Column(name = "PROVEEDOR_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "PEDIDO_URL", nullable = false)
    private String pedidoURL;


    public Proveedor() {
    }

    public Proveedor(Integer id, String nombre, String pedidoURL) {
        this.id = id;
        this.nombre = nombre;
        this.pedidoURL = pedidoURL;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPedidoURL() {
        return pedidoURL;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + id +
                ", nombre=" + nombre +
                ", minimo=" + pedidoURL + "]";
    }
}

