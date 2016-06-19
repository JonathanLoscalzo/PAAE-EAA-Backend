package ar.edu.uai.paradigms.dto.venta;

import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.translator.venta.FormaPagoTranslator;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jloscalzo on 26/05/16.
 */
public class FormaPagoDTO implements DTO<Integer> {

    @JsonProperty
    private String nombre;

    @JsonProperty
    private Integer id;

    @JsonProperty
    private Boolean permiteDarCambio;

    @JsonCreator
    public FormaPagoDTO(){

    }

    public Boolean getPermiteDarCambio() {
        return permiteDarCambio;
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

    @Override
    public Integer getId() {
        return this.id;
    }
}
