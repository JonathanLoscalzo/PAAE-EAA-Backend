package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.cliente.Cliente;
import ar.edu.uai.paradigms.dao.ClienteDAO;
import ar.edu.uai.paradigms.service.ClienteService;

/**
 * Created by Skeith on 20/05/2016.
 */
public class ClienteServiceImpl extends ServiceImpl<Cliente,Integer> implements ClienteService {



    public ClienteServiceImpl(ClienteDAO clienteDAO)
    {
        super(clienteDAO);
    }
}
