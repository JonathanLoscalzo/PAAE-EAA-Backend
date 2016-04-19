package ar.edu.uai.paradigms.dto.auto;

import ar.edu.uai.paradigms.dto.DTO;

/**
 * Created by jloscalzo on 13/04/16.
 */
public class AutoCriteriaDTO extends DTO<String> {
    private String name;

    public AutoCriteriaDTO() {}

    public AutoCriteriaDTO(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AutoCriteriaDTO{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected String getId() {
        return this.getName();
    }
}
