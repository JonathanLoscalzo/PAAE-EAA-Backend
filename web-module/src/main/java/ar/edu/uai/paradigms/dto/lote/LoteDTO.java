package ar.edu.uai.paradigms.dto.lote;

import ar.edu.uai.paradigms.dto.DTO;



import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by Hal on 18/04/2016.
 */
public class LoteDTO extends DTO<Integer> {
    private Integer id;

    private String detalle;
    private Date fechaVencimiento;
    private Date fechaEntrada;

    @JsonCreator
    public LoteDTO(@JsonProperty("id") Integer id,
                   @JsonProperty("fecha_vencimiento") Date fechaVencimiento,
                   @JsonProperty("fecha_entrada") Date fechaEntrada,
                   @JsonProperty("detalle") String detalle) {
        this.id = id;
        this.detalle = detalle;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaEntrada = fechaEntrada;
    }

    @Override
    public Integer getId() {
        return id;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + id + ", detalle=" + detalle + "]";
    }


    public String getDetalle() {
        return detalle;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }
}
