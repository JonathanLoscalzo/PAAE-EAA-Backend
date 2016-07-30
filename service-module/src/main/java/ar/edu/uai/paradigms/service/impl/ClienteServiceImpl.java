package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.cliente.Cliente;
import ar.edu.uai.model.venta.Venta;
import ar.edu.uai.paradigms.dao.ClienteDAO;
import ar.edu.uai.paradigms.service.ClienteService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skeith on 20/05/2016.
 */
public class ClienteServiceImpl extends ServiceImpl<Cliente,Integer> implements ClienteService {



    public ClienteServiceImpl(ClienteDAO clienteDAO)
    {
        super(clienteDAO);
    }

    @Override
    public List<Venta> retrieveClientSales(Integer user_id)
    {
        return new ArrayList<Venta>();
    }


}
