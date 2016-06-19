package ar.edu.uai.paradigms.translator.venta;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.Generics.ModelCriteria;
import ar.edu.uai.model.venta.Venta;
import ar.edu.uai.paradigms.dto.CriteriaDTO;
import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.dto.venta.VentaDTO;
import ar.edu.uai.paradigms.dto.venta.VentaFormaPagoDTO;
import ar.edu.uai.paradigms.translator.Generics.TranslatorImpl;

import java.util.List;

/**
 * Created by jloscalzo on 26/05/16.
 */
public class VentaTranslator extends TranslatorImpl<VentaDTO, Venta> {

    private VentaFormaPagoTranslator ventaFormaPagoTranslator;
    private VentaDetalleTranslator ventaDetalleTranslator;

    @Override
    public Venta translate(VentaDTO dto) {
        Venta v = new Venta();
        v.setNro(dto.getNro());
        v.setFecha(dto.getFecha());
        v.setId(dto.getId());
        v.setVentaFormasPago(ventaFormaPagoTranslator.translate(dto.getFormasPago()));
        return v;
    }

    @Override
    public VentaDTO translateToDTO(Venta v) {
        VentaDTO dto = new VentaDTO();
        dto.setFecha(v.getFecha());
        dto.setNro(v.getNro());
        dto.setId(v.getId());
        dto.setFormasPago(ventaFormaPagoTranslator.translateToDTO(v.getVentaFormasPago()));
        return dto;
    }

    @Override
    public ModelCriteria translateCriteria(CriteriaDTO<VentaDTO> modelCriteria) {
        return null;
    }

    public void setVentaFormaPagoTranslator(VentaFormaPagoTranslator ventaFormaPagoTranslator) {
        this.ventaFormaPagoTranslator = ventaFormaPagoTranslator;
    }

    public void setVentaDetalleTranslator(VentaDetalleTranslator ventaDetalleTranslator) {
        this.ventaDetalleTranslator = ventaDetalleTranslator;
    }
}
