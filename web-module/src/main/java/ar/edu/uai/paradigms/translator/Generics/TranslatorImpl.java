package ar.edu.uai.paradigms.translator.Generics;

import ar.edu.uai.model.Model;
import ar.edu.uai.model.ModelCriteria;
import ar.edu.uai.paradigms.dto.DTO;
import java.util.List;

/**
 * Created by jloscalzo on 19/04/16.
 */
public abstract class TranslatorImpl<A extends DTO<Integer>, A1 extends DTO<String>, A2 extends Model, A3 extends ModelCriteria> implements Translator {

    public abstract A2 translate(A dto) ;

    public abstract A translateToDTO(A2 auto) ;

    public abstract List<A> translateToDTO(List<A2> autos);

    public abstract A3 translateCriteria(A1 autoCriteriaDTO);
}