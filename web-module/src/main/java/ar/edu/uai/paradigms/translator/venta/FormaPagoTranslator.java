package ar.edu.uai.paradigms.translator.venta;

import ar.edu.uai.model.Generics.ModelCriteria;
import ar.edu.uai.model.formaPago.FormaPago;
import ar.edu.uai.model.formaPago.FormaPagoCriteria;
import ar.edu.uai.paradigms.dto.CriteriaDTO;
import ar.edu.uai.paradigms.dto.venta.FormaPagoDTO;
import ar.edu.uai.paradigms.translator.Generics.TranslatorImpl;

/**
 * Created by jloscalzo on 26/05/16.
 */
public class FormaPagoTranslator extends TranslatorImpl<FormaPagoDTO, FormaPago> {
    @Override
    public FormaPago translate(FormaPagoDTO dto) {
        FormaPago fp = new FormaPago(dto.getNombre(), dto.getPermiteDarCambio() == 1);
        fp.setId(dto.getId());

        return fp;
    }

    @Override
    public FormaPagoDTO translateToDTO(FormaPago fp) {
        if (fp != null) {
            return new FormaPagoDTO(fp.getNombre(), fp.getId(), fp.getPermiteDarCambio() ? 1 : 0);
        } else {
            return new FormaPagoDTO();
        }
    }

    @Override
    public ModelCriteria translateCriteria(CriteriaDTO<FormaPagoDTO> modelCriteria) {
        return new FormaPagoCriteria();
    }
}
