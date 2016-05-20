package ar.edu.uai.paradigms.translator.producto;


import ar.edu.uai.model.producto.Producto;
import ar.edu.uai.model.producto.ProductoCriteria;
import ar.edu.uai.model.proveedor.Proveedor;
import ar.edu.uai.paradigms.dto.producto.ProductoCriteriaDTO;
import ar.edu.uai.paradigms.dto.producto.ProductoDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hal on 18/04/2016.
 */
public class ProductoTranslator
{
    public Producto translate(ProductoDTO productoDTO, Proveedor proveedor)
    {
        return new Producto (productoDTO.getId(),
                            productoDTO.getName(),
                            productoDTO.getMinimum(),
                            productoDTO.getAmount(),
                            proveedor);
    }

    public ProductoDTO translateToDTO(Producto producto)
    {
        if (producto != null)
        {
            return new ProductoDTO( producto.getId(),
                    producto.getNombre(),
                    producto.getMinimo(),
                    producto.getCantidad(),
                    producto.getProveedor().getId());
        }
        return null;
    }

    public List<ProductoDTO> translateToDTO(List<Producto> productos) {
        List<ProductoDTO> productoResponse = new ArrayList<ProductoDTO>();
        for(Producto i : productos) {
            ProductoDTO productoDTO = this.translateToDTO(i);
            if(productoDTO != null) {
                productoResponse.add(productoDTO);
            }
        }
        return productoResponse;
    }

    public ProductoCriteria translateCriteria(ProductoCriteriaDTO productoCriteriaDTO) {
        return new ProductoCriteria();
    }
}
