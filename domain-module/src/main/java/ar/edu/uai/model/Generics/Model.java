package ar.edu.uai.model.Generics;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jloscalzo on 14/04/16.
 */
public abstract class Model<Identifier> {
    protected abstract Identifier getId();
    public Model(){
        //cuando se ejecuta esto?
        messageErrors = new LinkedList<String>();
    }
    private Collection<String> messageErrors;

    public boolean hasError(){
        return 0 < messageErrors.size();
    }

    public void addMessage (String message){
        // TODO: Acá puedo cambiar, y agregar un objeto error que tenga fecha, excepciones, codigo, etc
        messageErrors.add(message);
    }
}
