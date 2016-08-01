package ar.edu.uai.paradigms.dto.producto;

import ar.edu.uai.paradigms.dto.DTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Hal on 18/04/2016.
 */
public class ProductoDTO implements DTO<Integer> {
    private Integer amount;
    private Integer id;

    private String name;
    private Integer minimum;
    private Float price;
    private Integer supplier_id;

    @JsonCreator
    public ProductoDTO(@JsonProperty("id") Integer id,
                       @JsonProperty("name") String name,
                       @JsonProperty("minimum") Integer minimum,
                       @JsonProperty("supplier_id") Integer supplier_id,
                       @JsonProperty("price") Float price) {
        this.id = id;
        this.name = name;
        this.minimum = minimum;
        this.price = price;
        this.supplier_id = supplier_id;
    }

    public ProductoDTO(Integer id, String name, Integer minimum, Integer amount, Integer supplier_id, Float price) {
        this.id = id;
        this.name = name;
        this.minimum = minimum;
        this.amount = amount;
        this.price = price;
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

    public Float getPrice() {
        return price;
    }

    public Integer getSupplier_id() {
        return supplier_id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
