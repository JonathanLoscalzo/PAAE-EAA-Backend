package ar.edu.uai.paradigms.translator.lote;

import ar.edu.uai.model.lote.Lote;
import ar.edu.uai.model.lote.LoteCriteria;
import ar.edu.uai.model.producto.Producto;
import ar.edu.uai.paradigms.dto.lote.LoteCriteriaDTO;
import ar.edu.uai.paradigms.dto.lote.LoteDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Hal on 18/04/2016.
 */
public class LoteTranslator
{
    public Lote translate(LoteDTO loteDTO, Producto prod)
    {
        return new Lote(loteDTO.getId(),
                        loteDTO.getExpiration_date(),
                        loteDTO.getEntry_date(),
                        loteDTO.getDetail(),
                        prod,
                        loteDTO.getRemaining_units(),
                        loteDTO.getTotal_units());
    }

    public LoteDTO translateToDTO(Lote lote, Producto prod)
    {
        if (lote != null)
        {
            LoteDTO loteDTO = new LoteDTO( lote.getId(),
                    lote.getFechaVencimiento(),
                    lote.getFechaEntrada(),
                    lote.getDetalle(),
                    prod.getId(),
                    lote.getUnidadesTotales());

            loteDTO.setRemaining_units(lote.getUnidadesRestantes());
            return loteDTO;
        }
        return null;
    }

    public List<LoteDTO> translateToDTO(Collection<Lote> lotes, Producto prod) {
        List<LoteDTO> loteResponse = new ArrayList<LoteDTO>();
        for(Lote i : lotes) {
            LoteDTO loteDTO = this.translateToDTO(i,prod);
            if(loteDTO != null) {
                loteResponse.add(loteDTO);
            }
        }
        return loteResponse;
    }

    public LoteCriteria translateCriteria(LoteCriteriaDTO loteCriteriaDTO)
    {
        return new LoteCriteria();
    }
}
