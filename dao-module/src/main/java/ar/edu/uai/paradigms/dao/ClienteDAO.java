package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.cliente.Cliente;
import ar.edu.uai.model.cliente.ClienteCriteria;
import ar.edu.uai.paradigms.dao.Generics.PersistentDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Skeith on 20/05/2016.
 */
public class ClienteDAO implements PersistentDAO<Cliente, Integer, ClienteCriteria>
{
    @PersistenceContext(unitName = "paradigms-persistence-unit")
    private EntityManager entityManager;

    @Override
    public Cliente create(Cliente cliente) {
        this.entityManager.persist(cliente);
        return cliente;
    }

    @Override
    public Cliente retrieve(Integer id) {
        return this.entityManager.find(Cliente.class, id);
    }

    @Override
    public Cliente update(Cliente cliente) {
        return this.entityManager.merge(cliente);
    }

    @Override
    public void delete(Integer id) {
        Cliente c = this.retrieve(id);
        c.delete();
        this.update(c);
    }

    @Override
    public List<Cliente> retrieveByCriteria(ClienteCriteria clienteCriteria) {
        /*
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> query = cb.createQuery(Cliente.class);
        Root<Cliente> cliente = query.from(Cliente.class);

        // intente agregarle el where para el deleted pero no pude, asiq lo pase a sql jaja
        query.select(cliente).where(cb.equal(cliente.<~>get("deleted"), false);


        TypedQuery<Cliente> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();*/


        String query_string = "from Cliente c where c.deleted='false'";
        TypedQuery<Cliente> q = entityManager.createQuery(query_string, Cliente.class);

        return q.getResultList();
    }
}
