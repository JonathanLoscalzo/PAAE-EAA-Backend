package ar.edu.uai.paradigms.controller;

import ar.edu.uai.paradigms.dto.PersonDTO;
import ar.edu.uai.paradigms.service.PersonService;
import ar.edu.uai.paradigms.translator.PersonTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Federico Donnarumma on 10/15/14.
 */

@Controller
@RequestMapping("/persons")
public class PersonController {

    public PersonController(
            PersonService personService,
            PersonTranslator personTranslator) {
        super();
        this.personService = personService;
        this.personTranslator = personTranslator;
    }

    private static final Logger LOGGER = LoggerFactory
            .getLogger(PersonController.class);

    private PersonService personService;

    private PersonTranslator personTranslator;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO) {
        LOGGER.debug("Received DTO: " + personDTO);
        return new ResponseEntity<PersonDTO>(this.personTranslator.translateToDTO(this.personService
                .savePerson(this.personTranslator.translate(personDTO))), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<List<PersonDTO>> retrieveByCriteria(@RequestParam("name") String name) {
        LOGGER.debug("Received QUERY: " + name);
        return new ResponseEntity<List<PersonDTO>>(this.personTranslator.translateToDTO(this.personService
                .retrieveByCriteria(name)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
    public
    @ResponseBody
    ResponseEntity<PersonDTO> getPerson(@PathVariable Integer identifier) throws InterruptedException {
        Thread.sleep(Integer.valueOf(System.getProperty("sleepTime", "0")) * 1000);
        PersonDTO person = this.personTranslator.translateToDTO(this.personService.retrievePerson(identifier));
        if (person != null) {
            return new ResponseEntity<PersonDTO>(person, HttpStatus.OK);
        }
        return new ResponseEntity<PersonDTO>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{identifier}")
    public
    @ResponseBody
    ResponseEntity<String> deletePerson(@PathVariable Integer identifier) {
        this.personService.deletePerson(identifier);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
}