package ar.edu.uai.paradigms.dto.producto;

/**
 * Created by Skeith on 10/07/2016.
 */
public class ProductoPorAgotarseDTO {

    private Integer id;
    private String name;
    private Integer current_units;
    private Integer minimum_units;


    public ProductoPorAgotarseDTO(Integer id, String name, Integer current_units, Integer minimum_units)
    {
        this.id = id;
        this.name = name;
        this.current_units = current_units;
        this.minimum_units = minimum_units;
    }

    public Integer getId() {return  id;}
    public Integer getMinimum_units() {
        return minimum_units;
    }

    public Integer getCurrent_units() {
        return current_units;
    }

    public String getName() {
        return name;
    }
}
