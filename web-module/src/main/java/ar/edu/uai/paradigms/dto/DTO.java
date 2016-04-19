package ar.edu.uai.paradigms.dto;

import java.io.Serializable;

/**
 * Created by jloscalzo on 19/04/16.
 */
public abstract class DTO<I extends Serializable> {
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + this.getId() + "]";
    }

    protected abstract I getId();
}
