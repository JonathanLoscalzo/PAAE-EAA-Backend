package ar.edu.uai.paradigms.translator.producto;

import ar.edu.uai.model.producto.Producto;
import ar.edu.uai.paradigms.dto.producto.ProductoConUnidadesDTO;
import ar.edu.uai.paradigms.dto.producto.ProductoDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skeith on 09/07/2016.
 */
public class ProductoConUnidadesTranslator {

    public List<ProductoConUnidadesDTO> translateToDTO(List<Producto> productos)
    {
        List<ProductoConUnidadesDTO> productoResponse = new ArrayList<ProductoConUnidadesDTO>();
        for(Producto i : productos) {
            ProductoConUnidadesDTO productoDTO = new ProductoConUnidadesDTO(i.getNombre(),
                                                                            i.getCurrentUnits(),
                                                                            i.getTotalUnits());
            if(productoDTO != null) {
                productoResponse.add(productoDTO);
            }
        }
        return productoResponse;
    }
}
