package ar.edu.uai.model.item;

import ar.edu.uai.model.Generics.Model;

import javax.persistence.*;

@Entity
@Table(name = "ITEM")
@Access(AccessType.FIELD)
public class Item extends Model<Integer> {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRICE", nullable = false)
    private Integer price;

    @Column(name = "AMOUNT", nullable = false)
    private Integer amount;

    public Item() {
    }

    public Item(Integer id, String name, Integer price, Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
    public  int getAmount() {return amount;}

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + id + ", name=" + name + ", price=" + price + " , amount= " + amount +"]";
    }
}
