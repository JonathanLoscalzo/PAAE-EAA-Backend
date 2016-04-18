package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.auto.Auto;
import ar.edu.uai.model.auto.AutoCriteria;
import ar.edu.uai.paradigms.dao.AutoDAO;

/**
 * Created by jloscalzo on 14/04/16.
 */
public class AutoServiceImpl extends ServiceImpl<Auto,AutoCriteria> {

    public AutoServiceImpl(AutoDAO dao) {
        super(dao);
    }
}
