package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.venta.Venta;
import ar.edu.uai.paradigms.dao.Generics.PersistentDAO;
import ar.edu.uai.paradigms.dao.VentaDAO;
import ar.edu.uai.paradigms.service.FormaPagoService;
import ar.edu.uai.paradigms.service.VentaDetalleService;
import ar.edu.uai.paradigms.service.VentaService;

/**
 * Created by jloscalzo on 25/05/16.
 */
public class VentaServiceImpl extends ServiceImpl<Venta,Integer> implements VentaService {

    public VentaDetalleService ventaDetalleService;
    public FormaPagoService formaPagoService;

    public VentaServiceImpl(PersistentDAO dao){
        super(dao);
    }

    public void setVentaDetalleService(VentaDetalleService ventaDetalleService) {
        this.ventaDetalleService = ventaDetalleService;
    }

    public void setFormaPagoService(FormaPagoService formaPagoService) {
        this.formaPagoService = formaPagoService;
    }
}
