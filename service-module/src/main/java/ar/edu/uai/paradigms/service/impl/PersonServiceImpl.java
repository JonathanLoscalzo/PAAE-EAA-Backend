package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.person.Person;
import ar.edu.uai.model.person.PersonCriteria;
import ar.edu.uai.paradigms.dao.PersonDAO;
import ar.edu.uai.paradigms.service.PersonService;

public class PersonServiceImpl extends ServiceImpl<Person,PersonCriteria> implements PersonService {

    private PersonDAO personDAO;

    public PersonServiceImpl(PersonDAO personDAO) {
        super(personDAO);
    }
}
