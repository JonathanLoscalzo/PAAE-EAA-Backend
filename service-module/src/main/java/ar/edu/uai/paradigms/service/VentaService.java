package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.venta.Venta;

import java.util.List;

/**
 * Created by jloscalzo on 25/05/16.
 */
public interface VentaService extends Service<Venta, Integer>{
    List<Venta> GetClientSales(Integer client_id);
}
