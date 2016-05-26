package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.ventaDetalle.VentaDetalle;
import ar.edu.uai.paradigms.dao.Generics.PersistentDAO;
import ar.edu.uai.paradigms.service.VentaDetalleService;

/**
 * Created by jloscalzo on 25/05/16.
 */
public class VentaDetalleServiceImpl extends ServiceImpl<VentaDetalle, Integer>  implements VentaDetalleService {

    public VentaDetalleServiceImpl(PersistentDAO dao) {
        super(dao);
    }
}
