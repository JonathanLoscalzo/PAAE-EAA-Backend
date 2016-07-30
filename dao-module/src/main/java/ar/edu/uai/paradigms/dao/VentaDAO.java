package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.venta.Venta;
import ar.edu.uai.model.venta.VentaCriteria;
import ar.edu.uai.paradigms.dao.Generics.GenericDAO;
import org.hibernate.criterion.Restrictions;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jloscalzo on 25/05/16.
 */
public class VentaDAO extends GenericDAO<Venta, Integer, VentaCriteria> {
    public List<Venta> getSalesFromClient(Integer client_id) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Venta> query = cb.createQuery(Venta.class);
        Root<Venta> elems = query.from(Venta.class);
        query.select(elems);
        TypedQuery<Venta> typedQuery = getEntityManager().createQuery(query);
        List<Venta> list =  typedQuery.getResultList();

        return list.stream().filter(f -> f.getCliente().getId() == client_id).collect(Collectors.toList());
    }
}
