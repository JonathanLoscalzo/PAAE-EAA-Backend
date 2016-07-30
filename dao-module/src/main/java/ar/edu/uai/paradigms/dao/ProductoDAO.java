package ar.edu.uai.paradigms.dao;


import ar.edu.uai.model.producto.Producto;
import ar.edu.uai.model.producto.ProductoCriteria;
import ar.edu.uai.paradigms.dao.Generics.GenericDAO;
import ar.edu.uai.paradigms.dao.Generics.PersistentDAO;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Skeith on 17/04/2016.
 */
public class ProductoDAO extends GenericDAO<Producto, Integer, ProductoCriteria>
{
}
