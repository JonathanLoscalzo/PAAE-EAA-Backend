package ar.edu.uai.paradigms.dto;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by jloscalzo on 19/04/16.
 */
public interface DTO<I extends Serializable> {
    public String toString();

    public abstract I getId();

}
