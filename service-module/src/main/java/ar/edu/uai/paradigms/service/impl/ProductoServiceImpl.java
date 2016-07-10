package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.producto.Producto;
import ar.edu.uai.model.producto.ProductoCriteria;

import ar.edu.uai.paradigms.dao.ProductoDAO;
import ar.edu.uai.paradigms.service.ProductoService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public boolean hasStock(Integer id_producto, Integer cantidad) {
        return true;
    }

    @Override
    public void discount(Integer id, Integer cantidad) {
        Producto retrieve = (Producto) dao.retrieve(id);
        //TODO actualizar cantidad;
        dao.update(retrieve);
    }

    @Override
    public void restore(Integer id, Integer cantidad) {
        Producto retrieve = (Producto) dao.retrieve(id);
        //TODO actualizar cantidad;
        dao.update(retrieve);
    }


    public List<Producto> productsCloseToRunOut()
    {
        List<Producto> productos = this.retrieveByCriteria(null);
        List<Producto> productosPorAgotarse = new ArrayList<>();
        for(Producto p : productos)
        {
            if(p.porAgotarse())
                productosPorAgotarse.add(p);
        }

        return  productosPorAgotarse;
    }
}
