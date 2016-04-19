package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.auto.Auto;
import ar.edu.uai.model.auto.AutoCriteria;
import ar.edu.uai.paradigms.dao.AutoDAO;
import ar.edu.uai.paradigms.service.AutoService;

/**
 * Created by jloscalzo on 14/04/16.
 */
public class AutoServiceImpl extends ServiceImpl<Auto,AutoCriteria> implements AutoService{

    public AutoServiceImpl(AutoDAO dao) {
        super(dao);
    }
}
