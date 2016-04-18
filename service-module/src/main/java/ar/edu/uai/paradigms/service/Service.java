package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Model;
import ar.edu.uai.model.ModelCriteria;

import java.util.List;

/**
 * Created by jloscalzo on 14/04/16.
 */
public interface Service<Entity extends Model, Criteria extends ModelCriteria>{
    Entity save(Entity entity);

    Entity retrieve(Integer identifier);

    void delete(Integer identifier);

    List<Entity> retrieveByCriteria(Criteria criteria);
}
