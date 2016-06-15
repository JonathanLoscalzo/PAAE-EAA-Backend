package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.producto.Producto;
import ar.edu.uai.model.producto.ProductoCriteria;

import java.util.List;

/**
 * Created by Skeith on 16/05/2016.
 */
public interface ProductoService extends Service<Producto,Integer>
{

    boolean hasStock(Integer id, Integer cantidad);

    boolean exist(Integer id);

    void discount(Integer id, Integer cantidad);

    void restore(Integer id, Integer cantidad);
}