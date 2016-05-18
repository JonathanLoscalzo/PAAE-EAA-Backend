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

    private String name;
    private Integer minimum;
    private Integer amount;

    @JsonCreator
    public ProductoDTO (@JsonProperty("id") Integer id,
                        @JsonProperty("name") String name,
                        @JsonProperty("minimum") Integer minimum)
    {
        this.id = id;
        this.name = name;
        this.minimum = minimum;
        this.amount = 0;
    }

    public ProductoDTO(Integer id, String name, Integer minimum, Integer amount)
    {
        this.id = id;
        this.name = name;
        this.minimum = minimum;
        this.amount = amount;
    }



    @Override
    public Integer getId() {
        return id;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + id + ", nombre=" + name + "]";
    }


    public String getName() {
        return name;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public Integer getAmount() {
        return amount;
    }
}
