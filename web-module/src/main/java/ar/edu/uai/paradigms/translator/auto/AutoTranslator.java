package ar.edu.uai.paradigms.translator.auto;

import ar.edu.uai.model.auto.Auto;
import ar.edu.uai.model.auto.AutoCriteria;
import ar.edu.uai.paradigms.dto.auto.AutoCriteriaDTO;
import ar.edu.uai.paradigms.dto.auto.AutoDTO;
import ar.edu.uai.paradigms.translator.Generics.Translator;
import ar.edu.uai.paradigms.translator.Generics.TranslatorImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jloscalzo on 13/04/16.
 */
public class AutoTranslator extends TranslatorImpl<AutoDTO, AutoCriteriaDTO, Auto, AutoCriteria> implements Translator{
    @Override
    public Auto translate(AutoDTO dto) {
        return new Auto(dto.getId(), dto.getName());
    }

    @Override
    public AutoDTO translateToDTO(Auto auto) {
        if (auto != null) {
            return new AutoDTO(auto.getId(), auto.getName());
        }

        return null;
    }

    @Override
    public List<AutoDTO> translateToDTO(List<Auto> autos) {
        List<AutoDTO> personResponse = new ArrayList<AutoDTO>();
        for(Auto p : autos) {
            AutoDTO autoDTO = this.translateToDTO(p);
            if(autoDTO != null) {
                personResponse.add(autoDTO);
            }
        }

        return personResponse;
    }

    @Override
    public AutoCriteria translateCriteria(AutoCriteriaDTO autoCriteriaDTO) {
        return new AutoCriteria(autoCriteriaDTO.getName());
    }
}
