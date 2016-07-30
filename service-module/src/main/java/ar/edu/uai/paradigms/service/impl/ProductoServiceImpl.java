package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.producto.Producto;
import ar.edu.uai.paradigms.dao.ProductoDAO;
import ar.edu.uai.paradigms.service.LoteService;
import ar.edu.uai.paradigms.service.ProductoService;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skeith on 16/05/2016.
 */
public class ProductoServiceImpl extends ServiceImpl<Producto, Integer> implements ProductoService {
    private LoteService loteService;

    private ProductoDAO productoDAO;

    public ProductoServiceImpl(ProductoDAO productoDAO) {
        super(productoDAO);
        this.productoDAO = productoDAO;
    }


    @Override
    public boolean hasStock(Integer id_producto, Integer cantidad) {
        Producto producto = productoDAO.retrieve(id_producto);
        return producto.getCurrentUnits() >= cantidad;
    }

    @Override
    public void discount(Integer id, Integer cantidad) throws ValidationException {
        Producto retrieve = (Producto) dao.retrieve(id);

        retrieve.discount(cantidad);
        //dao.update(retrieve);
    }

    @Override
    public void restore(Integer id, Integer cantidad) {
        Producto retrieve = (Producto) dao.retrieve(id);
        //TODO actualizar cantidad;
        dao.update(retrieve);
    }


    public List<Producto> productsCloseToRunOut() {
        List<Producto> productos = this.retrieveByCriteria(null);
        List<Producto> productosPorAgotarse = new ArrayList<>();
        for (Producto p : productos) {
            if (p.porAgotarse())
                productosPorAgotarse.add(p);
        }

        return productosPorAgotarse;
    }

    public void setLoteService(LoteService loteService) {
        this.loteService = loteService;
    }

    public void setProductoDAO(ProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }
}
