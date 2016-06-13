package ar.edu.uai.paradigms.translator.venta;

import ar.edu.uai.model.Generics.ModelCriteria;
import ar.edu.uai.model.formaPago.FormaPago;
import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.dto.venta.FormaPagoDTO;
import ar.edu.uai.paradigms.translator.Generics.TranslatorImpl;

/**
 * Created by jloscalzo on 26/05/16.
 */
public class FormaPagoTranslator extends TranslatorImpl<FormaPagoDTO, FormaPago> {
    @Override
    public FormaPago translate(FormaPagoDTO dto) {
        FormaPago fp = new FormaPago(dto.getNombre(), dto.getPermiteDarCambio());
        fp.setId(dto.getId());

        return fp;
    }

    @Override
    public FormaPagoDTO translateToDTO(FormaPago fp) {
        FormaPagoDTO fpdto = new FormaPagoDTO();
        fpdto.setId(fp.getId());
        fpdto.setNombre(fp.getNombre());
        fpdto.setPermiteDarCambio(fp.getPermiteDarCambio());

        return fpdto;
    }

    @Override
    public ModelCriteria translateCriteria(DTO autoCriteriaDTO) {
        return null;
    }
}
