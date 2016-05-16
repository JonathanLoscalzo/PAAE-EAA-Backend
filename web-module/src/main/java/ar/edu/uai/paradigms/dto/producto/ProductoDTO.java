package ar.edu.uai.paradigms.dto.producto;

import ar.edu.uai.paradigms.dto.DTO;



import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by Hal on 18/04/2016.
 */
public class ProductoDTO extends DTO<Integer> {
    private Integer id;

    private String nombre;
    private Integer minimo;
    private Integer cantidad;

    @JsonCreator
    public ProductoDTO(@JsonProperty("id") Integer id,
                   @JsonProperty("nombre") String nombre,
                   @JsonProperty("minimo") Integer minimo,
                   @JsonProperty("cantidad") Integer cantidad)
    {
        this.id = id;
        this.nombre = nombre;
        this.minimo = minimo;
        this.cantidad = cantidad;
    }



    @Override
    public Integer getId() {
        return id;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + id + ", nombre=" + nombre + "]";
    }


    public String getNombre() {
        return nombre;
    }

    public Integer getMinimo() {
        return minimo;
    }

    public Integer getCantidad() {
        return cantidad;
    }
}
