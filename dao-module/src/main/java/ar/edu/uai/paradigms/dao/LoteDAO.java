package ar.edu.uai.paradigms.dao;


import ar.edu.uai.model.lote.Lote;
import ar.edu.uai.model.lote.LoteCriteria;
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
public class LoteDAO implements PersistentDAO<Lote, Integer, LoteCriteria>
{
    @PersistenceContext(unitName = "paradigms-persistence-unit")
    private EntityManager entityManager;

    @Override
    public Lote create(Lote lote)
    {
        this.entityManager.persist(lote);
        return lote;
    }

    @Override
    public Lote retrieve(Integer id) {
        return this.entityManager.find(Lote.class, id);
    }

    @Override
    public Lote update(Lote lote) {
        return this.entityManager.merge(lote);
    }

    @Override
    public void delete(Integer id) {
        this.entityManager.remove(this.retrieve(id));
    }

    @Override
    public List<Lote> retrieveByCriteria(LoteCriteria loteCriteria) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Lote> query = cb.createQuery(Lote.class);
        Root<Lote> lote = query.from(Lote.class);
        query.select(lote);

        TypedQuery<Lote> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
