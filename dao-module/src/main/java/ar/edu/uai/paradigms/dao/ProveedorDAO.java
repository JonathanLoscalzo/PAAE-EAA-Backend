package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.proveedor.Proveedor;
import ar.edu.uai.model.proveedor.ProveedorCriteria;
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
 * Created by Skeith on 19/05/2016.
 */
public class ProveedorDAO extends GenericDAO<Proveedor, Integer, ProveedorCriteria>
{}
