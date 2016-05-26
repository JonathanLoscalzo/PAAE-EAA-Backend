package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.ventaDetalle.VentaDetalle;
import ar.edu.uai.model.ventaDetalle.VentaDetalleCriteria;
import ar.edu.uai.paradigms.dao.Generics.GenericDAO;

import java.util.List;

/**
 * Created by jloscalzo on 25/05/16.
 */
public class VentaDetalleDAO extends GenericDAO<VentaDetalle, Integer, VentaDetalleCriteria> {

    @Override
    public List<VentaDetalle> retrieveByCriteria(VentaDetalleCriteria ventaDetalleCriteria) {
        return null;
    }
}
