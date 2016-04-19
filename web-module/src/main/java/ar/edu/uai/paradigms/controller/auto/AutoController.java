package ar.edu.uai.paradigms.controller.auto;

import ar.edu.uai.paradigms.controller.Controller;
import ar.edu.uai.paradigms.service.AutoService;
import ar.edu.uai.paradigms.translator.auto.AutoTranslator;

/**
 * Created by jloscalzo on 13/04/16.
 */
public class AutoController extends Controller {

    public AutoController(AutoService autoService, AutoTranslator autoTranslator){
        super(autoService, autoTranslator, AutoController.class);
    }
}
