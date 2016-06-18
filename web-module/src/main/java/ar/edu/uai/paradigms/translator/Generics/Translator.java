package ar.edu.uai.paradigms.translator.Generics;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.Generics.ModelCriteria;
import ar.edu.uai.paradigms.dto.CriteriaDTO;
import ar.edu.uai.paradigms.dto.DTO;

import java.util.Collection;
import java.util.List;

/**
 * Created by jloscalzo on 19/04/16.
 */
public interface Translator<ViewModel extends DTO, BusinessModel extends Model> {

    BusinessModel translate(ViewModel dto) ;

    Collection<BusinessModel> translate(Collection<ViewModel> autos);

    ViewModel translateToDTO(BusinessModel auto) ;

    Collection<ViewModel> translateToDTO(Collection<BusinessModel> autos);

    ModelCriteria translateCriteria(CriteriaDTO<ViewModel> modelCriteria);
}
