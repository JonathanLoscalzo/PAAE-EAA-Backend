package ar.edu.uai.paradigms.translator.venta;

import ar.edu.uai.model.Generics.ModelCriteria;
import ar.edu.uai.model.ventaDetalle.VentaDetalle;
import ar.edu.uai.paradigms.dto.CriteriaDTO;
import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.dto.venta.VentaDetalleDTO;
import ar.edu.uai.paradigms.translator.Generics.TranslatorImpl;
import ar.edu.uai.paradigms.translator.producto.ProductoTranslator;

import java.util.List;

/**
 * Created by jloscalzo on 26/05/16.
 */
public class VentaDetalleTranslator extends TranslatorImpl<VentaDetalleDTO, VentaDetalle> {
    private ProductoTranslator productoTranslator;

    @Override
    public VentaDetalle translate(VentaDetalleDTO dto) {
        VentaDetalle vd = new VentaDetalle();
        vd.setFila(dto.getFila());
        vd.setCantidad(dto.getCantidad());
        vd.setPrecio(dto.getPrecio());
        vd.setProducto(productoTranslator.translate(dto.getProducto()));
        vd.setId(dto.getId());

        return vd;
    }

    @Override
    public VentaDetalleDTO translateToDTO(VentaDetalle vd) {
        VentaDetalleDTO vddto = new VentaDetalleDTO();
        vddto.setFila(vd.getFila());
        vddto.setCantidad(vd.getCantidad());
        vddto.setPrecio(vd.getPrecio());
        vddto.setProducto(productoTranslator.translateToDTO(vd.getProducto()));
        vddto.setId(vd.getId());
        return vddto;
    }

    @Override
    public ModelCriteria translateCriteria(CriteriaDTO<VentaDetalleDTO> modelCriteria) {
        return null;
    }
}
