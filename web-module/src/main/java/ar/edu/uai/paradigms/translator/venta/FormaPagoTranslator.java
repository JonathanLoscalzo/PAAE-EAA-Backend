package ar.edu.uai.paradigms.translator.venta;

import ar.edu.uai.model.Generics.ModelCriteria;
import ar.edu.uai.model.formaPago.FormaPago;
import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.dto.venta.FormaPagoDTO;
import ar.edu.uai.paradigms.translator.Generics.TranslatorImpl;

import java.util.List;

/**
 * Created by jloscalzo on 26/05/16.
 */
public class FormaPagoTranslator extends TranslatorImpl<FormaPagoDTO, FormaPago> {
    @Override
    public FormaPago translate(FormaPagoDTO dto) {
        return null;
    }

    @Override
    public FormaPagoDTO translateToDTO(FormaPago auto) {
        return null;
    }

    @Override
    public List<FormaPagoDTO> translateToDTO(List<FormaPago> autos) {
        return null;
    }

    @Override
    public ModelCriteria translateCriteria(DTO autoCriteriaDTO) {
        return null;
    }
}
