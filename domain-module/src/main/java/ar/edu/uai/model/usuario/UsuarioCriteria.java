package ar.edu.uai.model.usuario;

import ar.edu.uai.model.Generics.ModelCriteria;

/**
 * Created by Skeith on 15/06/2016.
 */
public class UsuarioCriteria extends ModelCriteria<Integer> {

    @Override
    protected Integer getId() {
        return getId();
    }

    private String username;


    public UsuarioCriteria(String username) {
        this.username = username;

    }


    public String getUsername() {
        return username;
    }
}
