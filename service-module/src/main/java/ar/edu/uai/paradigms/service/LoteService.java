package ar.edu.uai.paradigms.service;


import ar.edu.uai.model.lote.Lote;
import ar.edu.uai.model.lote.LoteCriteria;
import java.util.List;

/**
 * Created by Skeith on 17/04/2016.
 */
public interface LoteService extends Service<Lote,Integer>
{

    Lote saveLote(Lote lote);

    Lote retrieveLote(Integer identifier);

    void deleteLote(Integer identifier);

    List<Lote> retrieveByCriteria(LoteCriteria criteria);
}
