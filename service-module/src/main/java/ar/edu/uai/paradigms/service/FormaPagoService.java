package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.formaPago.FormaPago;

/**
 * Created by jloscalzo on 25/05/16.
 */
public interface FormaPagoService extends Service<FormaPago,Integer> {
    /**
     * Debería hacer las validaciones con los lotes
     * @param id
     * @param cantidad
     * @return
     */
    boolean couldDiscount(Integer id, Double cantidad);

    void discount(Integer id, Double cantidad);
}
