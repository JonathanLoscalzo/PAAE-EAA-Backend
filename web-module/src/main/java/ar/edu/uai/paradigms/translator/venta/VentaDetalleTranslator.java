package ar.edu.uai.paradigms.translator.venta;

import ar.edu.uai.model.Generics.ModelCriteria;
import ar.edu.uai.model.ventaDetalle.VentaDetalle;
import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.dto.venta.VentaDetalleDTO;
import ar.edu.uai.paradigms.translator.Generics.TranslatorImpl;

import java.util.List;

/**
 * Created by jloscalzo on 26/05/16.
 */
public class VentaDetalleTranslator extends TranslatorImpl<VentaDetalleDTO, VentaDetalle> {
    @Override
    public VentaDetalle translate(VentaDetalleDTO dto) {
        return null;
    }

    @Override
    public VentaDetalleDTO translateToDTO(VentaDetalle auto) {
        return null;
    }

    @Override
    public List<VentaDetalleDTO> translateToDTO(List<VentaDetalle> autos) {
        return null;
    }

    @Override
    public ModelCriteria translateCriteria(DTO autoCriteriaDTO) {
        return null;
    }
}
