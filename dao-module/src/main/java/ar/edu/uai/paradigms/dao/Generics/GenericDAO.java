package ar.edu.uai.paradigms.dao.Generics;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by jloscalzo on 25/05/16.
 */
public abstract class GenericDAO<E, I, C> implements PersistentDAO<E, I, C> {

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext(unitName = "paradigms-persistence-unit")
    private EntityManager entityManager;
    protected Class<? extends E> daoType;

    public Class domainClass = getDomainClass();

    protected Class getDomainClass() {
        if (domainClass == null) {
            ParameterizedType thisType = (ParameterizedType) getClass()
                    .getGenericSuperclass();
            domainClass = (Class) thisType.getActualTypeArguments()[0];
        }

        return domainClass;
    }

    public E create(E e) {
        this.entityManager.persist(e);
        return e;
    }

    public E retrieve(I id) {
        return (E) this.entityManager.find(domainClass, id);
    }

    public E update(E e) {
        return this.entityManager.merge(e);
    }

    public void delete(I id) {
        this.entityManager.remove(this.retrieve(id));
    }

    public List<E> retrieveByCriteria(C c){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> query = cb.createQuery(domainClass);
        Root<E> elems = query.from(domainClass);
        query.select(elems);

        TypedQuery<E> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    };
}
