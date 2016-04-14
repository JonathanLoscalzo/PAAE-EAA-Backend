package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.person.Person;
import ar.edu.uai.model.person.PersonCriteria;
import ar.edu.uai.paradigms.dao.PersonDAO;

public class PersonServiceImpl extends ServiceImpl<Person,PersonCriteria> {

    private PersonDAO personDAO;

    public PersonServiceImpl(PersonDAO personDAO) {
        super(personDAO);
    }
}
