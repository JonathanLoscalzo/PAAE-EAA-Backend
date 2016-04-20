package ar.edu.uai.paradigms.translator.auto;

import ar.edu.uai.model.Generics.ModelCriteria;
import ar.edu.uai.model.auto.Auto;
import ar.edu.uai.model.auto.AutoCriteria;
import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.dto.auto.AutoCriteriaDTO;
import ar.edu.uai.paradigms.dto.auto.AutoDTO;
import ar.edu.uai.paradigms.translator.Generics.Translator;
import ar.edu.uai.paradigms.translator.Generics.TranslatorImpl;

import java.util.ArrayList;
import java.util.List;

public class AutoTranslator extends TranslatorImpl<AutoDTO, Auto> implements Translator {
    public Auto translate(AutoDTO dto) {
        return new Auto(dto.getId(), dto.getName());
    }

    public AutoDTO translateToDTO(Auto auto) {
        if (auto != null) {
            return new AutoDTO(auto.getId(), auto.getName());
        }

        return null;
    }

    public List<AutoDTO> translateToDTO(List<Auto> autos) {
        List<AutoDTO> personResponse = new ArrayList<AutoDTO>();
        for (Auto p : autos) {
            AutoDTO autoDTO = this.translateToDTO(p);
            if (autoDTO != null) {
                personResponse.add(autoDTO);
            }
        }

        return personResponse;
    }

    @Override
    public ModelCriteria translateCriteria(DTO autoCriteriaDTO) {
        return this.translateCriteria((AutoCriteriaDTO) autoCriteriaDTO);
    }

    public AutoCriteria translateCriteria(AutoCriteriaDTO autoCriteriaDTO) {
        return new AutoCriteria(autoCriteriaDTO.getName());
    }
}
