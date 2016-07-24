package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.formaPago.FormaPago;
import ar.edu.uai.model.formaPago.FormaPagoCriteria;
import ar.edu.uai.paradigms.dao.Generics.GenericDAO;
import ar.edu.uai.paradigms.dao.Generics.PersistentDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jloscalzo on 25/05/16.
 */
public class FormaPagoDAO extends GenericDAO<FormaPago, Integer, FormaPagoCriteria> implements PersistentDAO<FormaPago, Integer, FormaPagoCriteria> {
    @Override
    public List<FormaPago> retrieveByCriteria(FormaPagoCriteria formaPagoCriteria) {
        return new ArrayList<FormaPago>();
    }
}
