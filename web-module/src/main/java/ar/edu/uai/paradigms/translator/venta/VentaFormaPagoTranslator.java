package ar.edu.uai.paradigms.translator.venta;

import ar.edu.uai.model.Generics.ModelCriteria;
import ar.edu.uai.model.venta.VentaFormaPago;
import ar.edu.uai.paradigms.dto.CriteriaDTO;
import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.dto.venta.VentaFormaPagoDTO;
import ar.edu.uai.paradigms.translator.Generics.Translator;
import ar.edu.uai.paradigms.translator.Generics.TranslatorImpl;

/**
 * Created by jloscalzo on 12/06/16.
 */
public class VentaFormaPagoTranslator extends TranslatorImpl<VentaFormaPagoDTO, VentaFormaPago> {
    private FormaPagoTranslator formaPagoTranslator;
    private VentaTranslator ventaTranslator;

    @Override
    public VentaFormaPago translate(VentaFormaPagoDTO dto) {
        VentaFormaPago v = new VentaFormaPago(ventaTranslator.translate(dto.getVenta()),
                formaPagoTranslator.translate(dto.getFormaPago()),
                dto.getCantidad());
        v.setId(dto.getId());
        return v;
    }

    @Override
    public VentaFormaPagoDTO translateToDTO(VentaFormaPago bsmodels) {
        VentaFormaPagoDTO vfp = new VentaFormaPagoDTO(bsmodels.getCantidad(),
                formaPagoTranslator.translateToDTO(bsmodels.getFormaPago()),
                ventaTranslator.translateToDTO(bsmodels.getVenta()),
                bsmodels.getId());
        return vfp;
    }

    @Override
    public ModelCriteria translateCriteria(CriteriaDTO<VentaFormaPagoDTO> modelCriteria) {
        return null;
    }

    public void setFormaPagoTranslator(FormaPagoTranslator formaPagoTranslator) {
        this.formaPagoTranslator = formaPagoTranslator;
    }

    public void setVentaTranslator(VentaTranslator ventaTraslator) {
        this.ventaTranslator = ventaTraslator;
    }
}
