package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.Model;
import ar.edu.uai.model.ModelCriteria;
import ar.edu.uai.paradigms.dao.PersistentDAO;
import ar.edu.uai.paradigms.service.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jloscalzo on 14/04/16.
 */
public abstract class ServiceImpl<Entity extends Model, CriteriaEntity extends ModelCriteria> implements Service<Entity, CriteriaEntity>{
    protected PersistentDAO dao;

    public ServiceImpl(PersistentDAO dao) {
        this.dao = dao;
    }

    @Transactional
    public Entity save(Entity entity) {
        return (Entity) this.dao.create(entity);
    }

    public Entity retrieve(Integer identifier) {
        return (Entity) this.dao.retrieve(identifier);
    }

    @Transactional
    public void delete(Integer identifier) {
        this.dao.delete(identifier);
    }

    public List<Entity> retrieveByCriteria(CriteriaEntity criteriaEntity) {
        return this.dao.retrieveByCriteria(criteriaEntity);
    }
}
