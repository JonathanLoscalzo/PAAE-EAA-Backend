package ar.edu.uai.paradigms.translator.Generics;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.Generics.ModelCriteria;
import ar.edu.uai.paradigms.dto.CriteriaDTO;
import ar.edu.uai.paradigms.dto.DTO;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jloscalzo on 19/04/16.
 */
public abstract class TranslatorImpl<ViewModel extends DTO, BusinessModel extends Model> implements Translator <ViewModel , BusinessModel>{

    public abstract BusinessModel translate(ViewModel dto) ;
    public Collection<BusinessModel> translate(Collection<ViewModel> dtos){
        return dtos.stream().map((dto) -> translate(dto)).collect(Collectors.<BusinessModel>toList());
    }

    public abstract ViewModel translateToDTO(BusinessModel bsmodels) ;

    public Collection<ViewModel> translateToDTO(Collection<BusinessModel> bsmodels){
        return bsmodels.stream().map(dto -> translateToDTO(dto)).collect(Collectors.<ViewModel>toList());
    }

    @Deprecated
    public abstract ModelCriteria translateCriteria(CriteriaDTO<ViewModel> modelCriteria);
}