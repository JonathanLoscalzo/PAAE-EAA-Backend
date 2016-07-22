package ar.edu.uai.paradigms.translator.venta;

import ar.edu.uai.model.Generics.ModelCriteria;
import ar.edu.uai.model.ventaDetalle.VentaDetalle;
import ar.edu.uai.paradigms.dto.CriteriaDTO;
import ar.edu.uai.paradigms.dto.venta.VentaDetalleDTO;
import ar.edu.uai.paradigms.translator.Generics.TranslatorImpl;
import ar.edu.uai.paradigms.translator.producto.ProductoTranslator;

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
        return new VentaDetalleDTO(
                vd.getId(),
                vd.getFila(),
                productoTranslator.translateToDTO(vd.getProducto()),
                vd.getCantidad(),
                vd.getPrecio()
        );
    }

    @Override
    public ModelCriteria translateCriteria(CriteriaDTO<VentaDetalleDTO> modelCriteria) {
        return null;
    }
}
