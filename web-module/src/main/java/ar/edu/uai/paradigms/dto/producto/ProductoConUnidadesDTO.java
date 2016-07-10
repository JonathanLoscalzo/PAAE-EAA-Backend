package ar.edu.uai.paradigms.dto.producto;

import ar.edu.uai.paradigms.dto.DTO;

/**
 * Created by Skeith on 09/07/2016.
 */
public class ProductoConUnidadesDTO
{

    private String name;
    private Integer current_units;
    private Integer total_units;


    public ProductoConUnidadesDTO(String name, Integer current_units, Integer total_units)
    {
        this.name = name;
        this.current_units = current_units;
        this.total_units = total_units;
    }


    public Integer getTotal_units() {
        return total_units;
    }

    public Integer getCurrent_units() {
        return current_units;
    }

    public String getName() {
        return name;
    }





}
