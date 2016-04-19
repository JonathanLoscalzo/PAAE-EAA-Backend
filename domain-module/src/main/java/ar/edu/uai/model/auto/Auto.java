package ar.edu.uai.model.auto;

import ar.edu.uai.model.Model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jloscalzo on 14/04/16.
 */
public class Auto extends Model {

    @Id
    @GeneratedValue
    @Column(name = "AUTO_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    public Auto() {
    }

    public Auto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
