package ar.edu.uai.paradigms.dto.item;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Hal on 18/04/2016.
 */
public class ItemDTO {
    private Integer id;

    private String name;
    private int price;
    private int amount;

    @JsonCreator
    public ItemDTO(@JsonProperty("id") Integer id, @JsonProperty("name") String name, @JsonProperty("price") int price,
                   @JsonProperty("amount") Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
    public int getAmount() { return amount; }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + id + ", name=" + name + "]";
    }
}
