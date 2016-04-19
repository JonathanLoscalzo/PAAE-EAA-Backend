package ar.edu.uai.paradigms.dto.auto;

import ar.edu.uai.paradigms.dto.DTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jloscalzo on 13/04/16.
 */
public class AutoDTO extends DTO<Integer> {
    private Integer id;

    private String name;

    @JsonCreator
    public AutoDTO(@JsonProperty("id") Integer id, @JsonProperty("name") String name) {
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
