package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.formaPago.FormaPago;
import ar.edu.uai.model.venta.Venta;
import ar.edu.uai.paradigms.dao.Generics.PersistentDAO;
import ar.edu.uai.paradigms.service.FormaPagoService;
import ar.edu.uai.paradigms.service.Service;

/**
 * Created by jloscalzo on 25/05/16.
 */
public class FormaPagoServiceImpl extends ServiceImpl<FormaPago, Integer> implements FormaPagoService{

    public FormaPagoServiceImpl(PersistentDAO dao) {
        super(dao);
    }

    @Override
    public boolean couldDiscount(Integer id, Double cantidad) {
        return false;
    }

    @Override
    public void discount(Integer id, Double cantidad) {

    }
}
