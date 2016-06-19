package ar.edu.uai.paradigms.dto.producto;

import ar.edu.uai.paradigms.dto.DTO;



import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by Hal on 18/04/2016.
 */
public class ProductoDTO implements DTO<Integer> {
    private Integer id;

    private String name;
    private Integer minimum;
    private Integer amount;
    private Integer supplier_id;

    @JsonCreator
    public ProductoDTO (@JsonProperty("id") Integer id,
                        @JsonProperty("name") String name,
                        @JsonProperty("minimum") Integer minimum,
                        @JsonProperty("supplier_id") Integer supplier_id)
    {
        this.id = id;
        this.name = name;
        this.minimum = minimum;
        this.amount = 0;
        this.supplier_id = supplier_id;
    }

    public ProductoDTO(Integer id, String name, Integer minimum, Integer amount, Integer supplier_id)
    {
        this.id = id;
        this.name = name;
        this.minimum = minimum;
        this.amount = amount;
        this.supplier_id = supplier_id;
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

    public Integer getSupplier_id() {
        return supplier_id;
    }
}
