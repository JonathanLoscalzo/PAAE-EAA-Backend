package ar.edu.uai.paradigms.controller;

import ar.edu.uai.paradigms.controller.person.PersonController;
import ar.edu.uai.paradigms.service.Service;
import ar.edu.uai.paradigms.translator.Generics.Translator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jloscalzo on 19/04/16.
 */
public class Controller {
    protected final Logger LOGGER; //??
    protected Service service;
    protected Translator translator;

    public Controller(Service service, Translator translator, Class c){
        this.service = service;
        this.translator = translator;
        LOGGER = LoggerFactory.getLogger(c.getClass());
    }
}
