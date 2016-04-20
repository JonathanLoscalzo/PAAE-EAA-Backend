package ar.edu.uai.model.auto;

import ar.edu.uai.model.Generics.ModelCriteria;

/**
 * Created by jloscalzo on 14/04/16.
 */
public class AutoCriteria extends ModelCriteria<String> {

    private String name;

    public AutoCriteria() {}

    public AutoCriteria(String name) {
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
        return "AutoCriteria{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected String getId() {
        return this.getName();
    }
}
