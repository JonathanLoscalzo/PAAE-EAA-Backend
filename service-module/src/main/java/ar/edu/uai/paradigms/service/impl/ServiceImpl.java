package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.Generics.ModelCriteria;
import ar.edu.uai.paradigms.dao.Generics.PersistentDAO;
import ar.edu.uai.paradigms.service.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jloscalzo on 14/04/16.
 */
public abstract class ServiceImpl<Entity extends Model, Identifier> implements Service<Entity, Identifier> {
    protected PersistentDAO dao;

    public ServiceImpl(PersistentDAO dao) { this.dao = dao; }

    @Transactional
    public Entity save(Entity entity) {
        return (Entity) this.dao.create(entity);
    }

    public Entity retrieve(Identifier identifier) {
        return (Entity) this.dao.retrieve(identifier);
    }

    @Transactional
    public void delete(Identifier identifier) {
        this.dao.delete(identifier);
    }

    public List<Entity> retrieveByCriteria(ModelCriteria criteriaEntity) {
        return this.dao.retrieveByCriteria(criteriaEntity);
    }
}
