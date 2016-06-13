package ar.edu.uai.paradigms.dto;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by jloscalzo on 19/04/16.
 */
public abstract class DTO<I extends Serializable> {
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + this.getId() + "]";
    }

    public abstract I getId();

    protected Collection<String> messageErrors;

    protected boolean HasError = 0 < messageErrors.size();
}
