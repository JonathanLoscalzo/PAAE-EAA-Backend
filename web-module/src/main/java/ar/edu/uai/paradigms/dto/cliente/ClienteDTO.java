package ar.edu.uai.paradigms.dto.cliente;

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

    @JsonCreator
    public ClienteDTO(@JsonProperty("id") Integer id,
                      @JsonProperty("dni") Integer dni,
                      @JsonProperty("first_name") String first_name,
                      @JsonProperty("last_name") String last_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dni = dni;

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

    public Integer getDni() {
        return dni;
    }
}
