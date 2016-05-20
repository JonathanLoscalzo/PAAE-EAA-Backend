package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.proveedor.Proveedor;
import ar.edu.uai.paradigms.dao.ProveedorDAO;
import ar.edu.uai.paradigms.service.ProveedorService;

/**
 * Created by Skeith on 19/05/2016.
 */
public class ProveedorServiceImpl extends ServiceImpl<Proveedor,Integer> implements ProveedorService
{

    public ProveedorServiceImpl(ProveedorDAO proveedorDAO)
    {
        super(proveedorDAO);
    }
}
