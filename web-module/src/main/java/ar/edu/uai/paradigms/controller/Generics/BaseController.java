package ar.edu.uai.paradigms.controller.Generics;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.service.Service;
import ar.edu.uai.paradigms.translator.Generics.Translator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by jloscalzo on 19/04/16.
 */
public abstract class BaseController {
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class.getName());

    protected Service service;
    protected Translator<DTO, Model> translator;

    public BaseController(Service service, Translator<DTO, Model> translator){
        this.service = service;
        this.translator = translator;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{identifier}")
    public
    @ResponseBody
    ResponseEntity<String> delete(@PathVariable Integer identifier) {
        this.service.delete(identifier);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    ResponseEntity<DTO> create(@RequestBody DTO dto) {
        Model model = this.translator.translate(dto);
        Model modelP = this.service.save(model);
        DTO output = this.translator.translateToDTO(modelP);
        return new ResponseEntity<>(output, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
    public
    @ResponseBody
    ResponseEntity<DTO> getPerson(@PathVariable Integer identifier) throws InterruptedException {
        Model retrieve = this.service.retrieve(identifier);
        DTO dto = this.translator.translateToDTO(retrieve);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
