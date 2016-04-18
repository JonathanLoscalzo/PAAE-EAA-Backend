package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.auto.Auto;
import ar.edu.uai.model.auto.AutoCriteria;

import java.beans.PersistenceDelegate;
import java.util.List;

/**
 * Created by jloscalzo on 14/04/16.
 */
public class AutoDAO implements PersistentDAO<Auto, Integer, AutoCriteria> {
    @Override
    public Auto create(Auto auto) {
        return null;
    }

    @Override
    public Auto retrieve(Integer id) {
        return null;
    }

    @Override
    public Auto update(Auto auto) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Auto> retrieveByCriteria(AutoCriteria autoCriteria) {
        return null;
    }
}
