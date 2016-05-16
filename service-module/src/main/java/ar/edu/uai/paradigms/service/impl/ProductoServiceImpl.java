package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.producto.Producto;
import ar.edu.uai.model.producto.ProductoCriteria;

import ar.edu.uai.paradigms.dao.ProductoDAO;
import ar.edu.uai.paradigms.service.ProductoService;

import java.util.List;

/**
 * Created by Skeith on 16/05/2016.
 */
public class ProductoServiceImpl extends ServiceImpl<Producto,Integer> implements ProductoService
{
    private ProductoDAO productoDAO;
    public ProductoServiceImpl(ProductoDAO productoDAO) {
        super(productoDAO);
        this.productoDAO = productoDAO;
    }
    @Override
    public Producto saveProducto(Producto producto) {
        return this.productoDAO.create(producto);
    }

    @Override
    public Producto retrieveProducto(Integer identifier) {
        return this.productoDAO.retrieve(identifier);
    }

    @Override
    public void deleteProducto(Integer identifier)
    {
        this.productoDAO.delete(identifier);
    }

    @Override
    public List<Producto> retrieveByCriteria(ProductoCriteria criteria)
    {
        return this.productoDAO.retrieveByCriteria(criteria);
    }

}
