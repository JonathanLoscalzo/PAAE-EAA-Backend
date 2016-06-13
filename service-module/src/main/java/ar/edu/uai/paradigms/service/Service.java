package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.Generics.ModelCriteria;

import java.util.List;

/**
 * Created by jloscalzo on 14/04/16.
 */
public interface Service<Entity extends Model, Identity>{
    Entity save(Entity entity);

    Entity retrieve(Identity identifier);

    void delete(Identity identifier);

    List<Entity> retrieveByCriteria(ModelCriteria criteria);

    Boolean validateModel(Entity e);
}
