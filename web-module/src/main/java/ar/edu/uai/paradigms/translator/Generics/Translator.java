package ar.edu.uai.paradigms.translator.Generics;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.Generics.ModelCriteria;
import ar.edu.uai.paradigms.dto.DTO;

import java.util.List;

/**
 * Created by jloscalzo on 19/04/16.
 */
public interface Translator<ViewModel extends DTO, BusinessModel extends Model> {

    public abstract BusinessModel translate(ViewModel dto) ;

    public abstract ViewModel translateToDTO(BusinessModel auto) ;

    public abstract List<ViewModel> translateToDTO(List<BusinessModel> autos);

    public abstract ModelCriteria translateCriteria(DTO autoCriteriaDTO);
}
