package ar.edu.uai.paradigms.dao.Generics;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by jloscalzo on 25/05/16.
 */
public abstract class GenericDAO<E, I, C> implements PersistentDAO<E, I, C> {

    @PersistenceContext(unitName = "paradigms-persistence-unit")
    private EntityManager entityManager;
    protected Class<? extends E> daoType;

    public E create(E e) {
        this.entityManager.persist(e);
        return e;
    }

    public E retrieve(I id) {
        return this.entityManager.find(daoType, id);
    }

    public E update(E e) {
        return this.entityManager.merge(e);
    }

    public void delete(I id) {
        this.entityManager.remove(this.retrieve(id));
    }

    public abstract List<E> retrieveByCriteria(C c);
}
