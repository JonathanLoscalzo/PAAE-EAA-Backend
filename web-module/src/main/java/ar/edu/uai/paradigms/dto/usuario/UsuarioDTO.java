package ar.edu.uai.paradigms.dto.usuario;

import ar.edu.uai.paradigms.dto.DTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Skeith on 15/06/2016.
 */
public class UsuarioDTO implements DTO<Integer>
{
    private Integer id;
    private String username;
    private String password;

    @JsonCreator
    public UsuarioDTO ( @JsonProperty("id") Integer id,
                        @JsonProperty("username") String username,
                        @JsonProperty("password") String password)
    {
        this.id = id;
        this.username = username;
        this.password = password;

    }


    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}