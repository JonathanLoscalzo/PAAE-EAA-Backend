package ar.edu.uai.paradigms.dto.venta;

import ar.edu.uai.paradigms.dto.DTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jloscalzo on 26/05/16.
 */
public class FormaPagoDTO implements DTO<Integer> {

    private String nombre;
    private Integer id;
    private Integer permiteDarCambio;

    public FormaPagoDTO(){

    }

    @JsonCreator
    public FormaPagoDTO(@JsonProperty("id") Integer id,
                        @JsonProperty("nombre") String nombre,
                        @JsonProperty("permiteDarCambio") Integer permiteDarCambio) {
        this.nombre = nombre;
        this.id = id;
        this.permiteDarCambio = permiteDarCambio;
    }

    public Integer getPermiteDarCambio() {
        return permiteDarCambio;
    }

    public void setPermiteDarCambio(Integer permiteDarCambio) {
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

    @Override
    public Integer getId() {
        return this.id;
    }
}
