package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.person.Person;
import ar.edu.uai.model.person.PersonCriteria;
import ar.edu.uai.paradigms.dao.Generics.GenericDAO;
import ar.edu.uai.paradigms.dao.Generics.PersistentDAO;

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
 * Created by Federico on 19/10/2014.
 */
public class PersonDAO extends GenericDAO<Person, Integer, PersonCriteria> {

    @Override
    public List<Person> retrieveByCriteria(PersonCriteria personCriteria) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Person> query = cb.createQuery(Person.class);
        Root<Person> person = query.from(Person.class);
        query.select(person);
        List<Predicate> predicates = new ArrayList<Predicate>();

        if(personCriteria.getName() != null) {
            predicates.add(cb.and(cb.like(person.<String>get("name"), "%" + personCriteria.getName() + "%")));
        }

        if(personCriteria.getMinAge() != null) {
            predicates.add(cb.and(cb.ge(person.<Integer>get("age"), personCriteria.getMinAge())));
        }

        if(personCriteria.getMaxAge() != null) {
            predicates.add(cb.and(cb.le(person.<Integer>get("age"), personCriteria.getMaxAge())));
        }
        if(!predicates.isEmpty()) {
            query.where(predicates.toArray(new Predicate[predicates.size()]));
        }

        TypedQuery<Person> typedQuery = getEntityManager().createQuery(query);

        return typedQuery.getResultList();
    }
}
