package ar.edu.uai.paradigms.dao;


import ar.edu.uai.model.producto.Producto;
import ar.edu.uai.model.producto.ProductoCriteria;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skeith on 17/04/2016.
 */
public class ProductoDAO implements PersistentDAO<Producto, Integer, ProductoCriteria>
{
    @PersistenceContext(unitName = "paradigms-persistence-unit")
    private EntityManager entityManager;

    @Override
    public Producto create(Producto producto) {
        this.entityManager.persist(producto);
        return producto;
    }

    @Override
    public Producto retrieve(Integer id) {
        return this.entityManager.find(Producto.class, id);
    }

    @Override
    public Producto update(Producto producto) {
        return this.entityManager.merge(producto);
    }

    @Override
    public void delete(Integer id) {
        this.entityManager.remove(this.retrieve(id));
    }

    @Override
    public List<Producto> retrieveByCriteria(ProductoCriteria productoCriteria) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Producto> query = cb.createQuery(Producto.class);
        Root<Producto> producto = query.from(Producto.class);
        query.select(producto);

        TypedQuery<Producto> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
