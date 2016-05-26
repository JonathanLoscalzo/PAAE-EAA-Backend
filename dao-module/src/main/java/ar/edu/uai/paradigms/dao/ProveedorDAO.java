package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.proveedor.Proveedor;
import ar.edu.uai.model.proveedor.ProveedorCriteria;
import ar.edu.uai.paradigms.dao.Generics.PersistentDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Skeith on 19/05/2016.
 */
public class ProveedorDAO implements PersistentDAO<Proveedor, Integer, ProveedorCriteria>
{
    @PersistenceContext(unitName = "paradigms-persistence-unit")
    private EntityManager entityManager;

    @Override
    public Proveedor create(Proveedor proveedor) {
        this.entityManager.persist(proveedor);
        return proveedor;
    }

    @Override
    public Proveedor retrieve(Integer id)
    {
        return this.entityManager.find(Proveedor.class, id);
    }

    @Override
    public Proveedor update(Proveedor proveedor)
    {
        return this.entityManager.merge(proveedor);
    }

    @Override
    public void delete(Integer id)
    {
        this.entityManager.remove(this.retrieve(id));
    }

    @Override
    public List<Proveedor> retrieveByCriteria(ProveedorCriteria proveedorCriteria)
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Proveedor> query = cb.createQuery(Proveedor.class);
        Root<Proveedor> proveedor = query.from(Proveedor.class);
        query.select(proveedor);

        TypedQuery<Proveedor> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
