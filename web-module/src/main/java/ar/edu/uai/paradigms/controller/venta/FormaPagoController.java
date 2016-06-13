package ar.edu.uai.paradigms.controller.venta;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.service.Service;
import ar.edu.uai.paradigms.translator.Generics.Translator;
import org.springframework.stereotype.Controller;

/**
 * Created by jloscalzo on 13/06/16.
 */

public class FormaPagoController extends ar.edu.uai.paradigms.controller.Generics.Controller {

    public FormaPagoController(Service service, Translator<DTO, Model> translator) {
        super(service, translator);
    }
}
