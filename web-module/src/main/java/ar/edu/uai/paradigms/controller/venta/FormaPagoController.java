package ar.edu.uai.paradigms.controller.venta;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.paradigms.controller.Generics.BaseController;
import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.dto.venta.FormaPagoDTO;
import ar.edu.uai.paradigms.dto.venta.criterias.FormaPagoCriteriaDTO;
import ar.edu.uai.paradigms.service.Service;
import ar.edu.uai.paradigms.translator.Generics.Translator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jloscalzo on 13/06/16.
 */
@RequestMapping("/FormasPago")
public class FormaPagoController extends BaseController<FormaPagoDTO, FormaPagoCriteriaDTO> {

    public FormaPagoController(Service service, Translator<DTO, Model> translator) {
        super(service, translator);
    }
}
