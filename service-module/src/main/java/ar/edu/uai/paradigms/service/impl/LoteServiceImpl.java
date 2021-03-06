package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.lote.Lote;
import ar.edu.uai.model.lote.LoteCriteria;
import ar.edu.uai.paradigms.dao.LoteDAO;
import ar.edu.uai.paradigms.service.LoteService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Skeith on 17/04/2016.
 */
public class LoteServiceImpl extends ServiceImpl<Lote,Integer> implements LoteService
{
    private LoteDAO loteDAO;

    public LoteServiceImpl(LoteDAO loteDAO) {
        super(loteDAO);
        this.loteDAO = loteDAO;
    }

    @Transactional
    public void consumeUnits(Lote lote, int amount)
    {
        lote.consumirUnidades(amount);
        loteDAO.update(lote);
    }

    public void consumeUnits(int loteID, int amount)
    {
        consumeUnits(loteDAO.retrieve(loteID),amount);
    }


}
