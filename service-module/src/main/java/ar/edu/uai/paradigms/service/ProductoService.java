package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.producto.Producto;
import ar.edu.uai.model.producto.ProductoCriteria;

import java.util.List;

/**
 * Created by Skeith on 16/05/2016.
 */
public interface ProductoService extends Service<Producto,Integer>
{


        Producto retrieveProducto(Integer identifier);

        void deleteProducto(Integer identifier);

        List<Producto> retrieveByCriteria(ProductoCriteria criteria);
}