package ar.edu.uai.paradigms.translator.producto;

import ar.edu.uai.model.producto.Producto;
import ar.edu.uai.paradigms.dto.producto.ProductoConUnidadesDTO;
import ar.edu.uai.paradigms.dto.producto.ProductoPorAgotarseDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skeith on 10/07/2016.
 */
public class ProductoPorAgotarseTranslator {

    public List<ProductoPorAgotarseDTO> translateToDTO(List<Producto> productos)
    {
        List<ProductoPorAgotarseDTO> productoResponse = new ArrayList<>();
        for(Producto p : productos) {
            ProductoPorAgotarseDTO productoDTO = new ProductoPorAgotarseDTO(p.getId(),
                                                                            p.getNombre(),
                                                                            p.getCurrentUnits(),
                                                                            p.getMinimo());
            if(productoDTO != null) {
                productoResponse.add(productoDTO);
            }
        }
        return productoResponse;
    }
}
