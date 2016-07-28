package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.venta.Venta;
import ar.edu.uai.model.venta.VentaCriteria;
import ar.edu.uai.paradigms.dao.Generics.GenericDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jloscalzo on 25/05/16.
 */
public class VentaDAO extends GenericDAO<Venta, Integer, VentaCriteria> {
    @Override
    public List<Venta> retrieveByCriteria(VentaCriteria ventaCriteria) {
        return new ArrayList<Venta>();
    }
}
