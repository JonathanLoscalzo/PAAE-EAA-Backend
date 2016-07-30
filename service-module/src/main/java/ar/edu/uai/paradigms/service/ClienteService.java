package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.cliente.Cliente;
import ar.edu.uai.model.venta.Venta;

import java.util.List;

/**
 * Created by Skeith on 20/05/2016.
 */
public interface ClienteService extends Service<Cliente,Integer>
{
    List<Venta> retrieveClientSales(Integer user_id);
}
