package ar.edu.uai.paradigms.translator.venta;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.Generics.ModelCriteria;
import ar.edu.uai.model.venta.Venta;
import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.dto.venta.VentaDTO;
import ar.edu.uai.paradigms.translator.Generics.TranslatorImpl;

import java.util.List;

/**
 * Created by jloscalzo on 26/05/16.
 */
public class VentaTranslator extends TranslatorImpl<VentaDTO, Venta> {
    @Override
    public List translateToDTO(List autos) {
        return null;
    }

    @Override
    public Venta translate(VentaDTO dto) {
        return null;
    }

    @Override
    public VentaDTO translateToDTO(Venta auto) {
        return null;
    }

    @Override
    public ModelCriteria translateCriteria(DTO autoCriteriaDTO) {
        return null;
    }
}
