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
    public Venta translate(VentaDTO dto) {
        Venta v = new Venta();
        v.setNro(dto.nro);
        v.setFecha(dto.fecha);

        return v;
    }

    @Override
    public VentaDTO translateToDTO(Venta v) {
        VentaDTO dto = new VentaDTO();
        dto.fecha = v.getFecha();
        dto.nro = v.getNro();
        dto.id = v.getId();

        return dto;
    }

    @Override
    public ModelCriteria translateCriteria(DTO autoCriteriaDTO) {
        return null;
    }
}
