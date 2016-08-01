package ar.edu.uai.paradigms.translator.producto;


import ar.edu.uai.model.Generics.ModelCriteria;
import ar.edu.uai.model.producto.Producto;
import ar.edu.uai.model.producto.ProductoCriteria;
import ar.edu.uai.model.proveedor.Proveedor;
import ar.edu.uai.paradigms.dto.CriteriaDTO;
import ar.edu.uai.paradigms.dto.producto.ProductoDTO;
import ar.edu.uai.paradigms.translator.Generics.TranslatorImpl;
import ar.edu.uai.paradigms.translator.proveedor.ProveedorTranslator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hal on 18/04/2016.
 */
public class ProductoTranslator extends TranslatorImpl<ProductoDTO, Producto> {
    private ProveedorTranslator proveedorTranslator;

    public Producto translate(ProductoDTO productoDTO, Proveedor proveedor) {
        return new Producto(productoDTO.getId(),
                productoDTO.getName(),
                productoDTO.getMinimum(),
                proveedor,
                productoDTO.getPrice());
    }

    public Producto translate(ProductoDTO productoDTO) {
        Proveedor p = new Proveedor();
        if (productoDTO == null)
            return new Producto();
        return new Producto(productoDTO.getId(),
                productoDTO.getName(),
                productoDTO.getMinimum(),
                p/*proveedorTranslator.translate()*/,
                productoDTO.getPrice());
    }

    public ProductoDTO translateToDTO(Producto producto) {
        if (producto != null) {
            return new ProductoDTO(producto.getId(),
                    producto.getNombre(),
                    producto.getMinimo(),
                    producto.getCurrentUnits(),
                    producto.getProveedor().getId(),
                    producto.getPrice());
        }
        return null;
    }

    @Override
    public ModelCriteria translateCriteria(CriteriaDTO<ProductoDTO> modelCriteria) {
        return new ProductoCriteria();
    }

    public List<ProductoDTO> translateToDTO(List<Producto> productos) {
        List<ProductoDTO> productoResponse = new ArrayList<ProductoDTO>();
        for (Producto i : productos) {
            ProductoDTO productoDTO = this.translateToDTO(i);
            if (productoDTO != null) {
                productoResponse.add(productoDTO);
            }
        }
        return productoResponse;
    }

    public void setProveedorTranslator(ProveedorTranslator proveedorTranslator) {
        this.proveedorTranslator = proveedorTranslator;
    }
}
