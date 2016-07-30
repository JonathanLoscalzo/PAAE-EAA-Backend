package ar.edu.uai.paradigms.dto.cliente;

import ar.edu.uai.model.usuario.Usuario;
import ar.edu.uai.paradigms.dto.DTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Skeith on 20/05/2016.
 */
public class ClienteDTO implements DTO<Integer> {
    private Integer id;
    private String first_name;
    private String last_name;
    private Integer dni;
    private Integer user_id;
    @JsonCreator
    public ClienteDTO(@JsonProperty("id") Integer id,
                      @JsonProperty("dni") Integer dni,
                      @JsonProperty("first_name") String first_name,
                      @JsonProperty("last_name") String last_name,
                      @JsonProperty("user_id") Integer user_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dni = dni;
        this.user_id = user_id;

    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }
    public Integer getUser_id() {return user_id; }
    public Integer getDni() {
        return dni;
    }
}
