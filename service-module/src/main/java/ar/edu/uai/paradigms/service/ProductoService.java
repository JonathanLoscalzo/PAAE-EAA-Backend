package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.producto.Producto;
import ar.edu.uai.model.producto.ProductoCriteria;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * Created by Skeith on 16/05/2016.
 */
public interface ProductoService extends Service<Producto,Integer>
{
    boolean hasStock(Integer id, Integer cantidad);

    void discount(Integer id, Integer cantidad) throws ValidationException;

    void restore(Integer id, Integer cantidad);

    List<Producto> productsCloseToRunOut();

}