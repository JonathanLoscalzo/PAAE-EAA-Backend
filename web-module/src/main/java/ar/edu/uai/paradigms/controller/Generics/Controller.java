package ar.edu.uai.paradigms.controller.Generics;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.service.Service;
import ar.edu.uai.paradigms.translator.Generics.Translator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jloscalzo on 19/04/16.
 */
public class Controller {
    protected static final Logger LOGGER = LoggerFactory.getLogger(Controller.class.getName());

    protected Service service;
    protected Translator<DTO, Model> translator;

    public Controller(Service service, Translator<DTO, Model> translator){
        this.service = service;

        this.translator = translator;
    }
}
