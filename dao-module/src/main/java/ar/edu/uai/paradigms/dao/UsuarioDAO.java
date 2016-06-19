package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.usuario.Usuario;
import ar.edu.uai.model.usuario.UsuarioCriteria;
import ar.edu.uai.paradigms.dao.Generics.GenericDAO;
import ar.edu.uai.paradigms.dao.Generics.PersistentDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skeith on 15/06/2016.
 */
public class UsuarioDAO implements PersistentDAO<Usuario, Integer, UsuarioCriteria> {
    @PersistenceContext(unitName = "paradigms-persistence-unit")
    private EntityManager entityManager;

    @Override
    public Usuario create(Usuario usuario) {
        this.entityManager.persist(usuario);
        return usuario;
    }

    @Override
    public Usuario retrieve(Integer id) {
        return this.entityManager.find(Usuario.class, id);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return this.entityManager.merge(usuario);
    }

    @Override
    public void delete(Integer id) {
        this.entityManager.remove(this.retrieve(id));
    }

    @Override
    public List<Usuario> retrieveByCriteria(UsuarioCriteria usuarioCriteria) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Usuario> query = cb.createQuery(Usuario.class);
        Root<Usuario> usuario = query.from(Usuario.class);
        query.select(usuario);

        TypedQuery<Usuario> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();


    }

    public List<Usuario> retrieveByUsername(String username) {

        //sql injection a morir jajaj
        String query_string = "from Usuario u where u.username='" +username+"'";
        TypedQuery<Usuario> q = entityManager.createQuery(query_string, Usuario.class);

        return q.getResultList();
    }
}