package ar.edu.uai.model.cliente;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.venta.Venta;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Skeith on 20/05/2016.
 */

@Entity
@Table(name = "CLIENTE")
@Access(AccessType.FIELD)
public class Cliente extends Model<Integer>
{
    @Id
    @GeneratedValue
    @Column(name = "CLIENTE_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false)
    private String apellido;

    @Column(name = "DNI", nullable = false)
    private Integer dni;

    @OneToMany
    private Collection<Venta> ventas;

    public Cliente(){}
    public Cliente(Integer id, Integer dni, String nombre, String apellido) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getDni() {
        return dni;
    }
}
