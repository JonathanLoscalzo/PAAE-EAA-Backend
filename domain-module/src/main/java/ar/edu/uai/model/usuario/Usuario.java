package ar.edu.uai.model.usuario;

import ar.edu.uai.model.Generics.Model;

import javax.persistence.*;
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


    public Usuario(){}
    public Usuario(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
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
}
