package ar.edu.uai.model.usuario;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.venta.Venta;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Skeith on 15/06/2016.
 */

@Entity
@Table(name = "USUARIO")
@Access(AccessType.FIELD)
public class Usuario extends Model<Integer>
{
    @Id
    @GeneratedValue
    @Column(name = "USUARIO_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "USERNAME", nullable = false)
    private String username;


    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ROLE", nullable = false)
    private String role;

    public Collection<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(Collection<Venta> ventas) {
        this.ventas = ventas;
    }

    @OneToMany
    private Collection<Venta> ventas;

    public Usuario(){}
    public Usuario(Integer id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.ventas = new ArrayList();
    }

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getRole(){ return  role;}
}
