package ar.edu.uai.paradigms.controller.Generics;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.Generics.ModelCriteria;
import ar.edu.uai.paradigms.dto.CriteriaDTO;
import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.service.Service;
import ar.edu.uai.paradigms.translator.Generics.Translator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


/**
 * Created by jloscalzo on 19/04/16.
 */
public abstract class BaseController<viewModel extends DTO, criteriaViewModel extends CriteriaDTO> {
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class.getName());

    protected Service service;
    protected Translator translator;

    public BaseController(Service service, Translator translator){
        this.service = service;
        this.translator = translator;
    }

    //https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
    @ExceptionHandler(Exception.class)
    public void handleExceptions(Exception anExc) {
        anExc.printStackTrace(); // do something better than this ;)
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
    ResponseEntity<viewModel> create(@RequestBody viewModel dto) {
        return createHook(dto);
    }

    protected ResponseEntity<viewModel> createHook(@RequestBody viewModel dto) {
        Model model = this.translator.translate(dto);
        Model modelP = this.service.save(model);
        viewModel output = (viewModel) this.translator.translateToDTO(modelP);
        return new ResponseEntity<>(output, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
    public
    @ResponseBody
    ResponseEntity<viewModel> getById(@PathVariable Integer identifier) throws InterruptedException {
        return getByIdHook(identifier);
    }

    protected ResponseEntity<viewModel> getByIdHook(@PathVariable Integer identifier) {
        Model retrieve = this.service.retrieve(identifier);
        viewModel dto = (viewModel) this.translator.translateToDTO(retrieve);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<Collection<DTO>> retrieveByCriteria(criteriaViewModel criteriaDto) {
        return retrieveByCriteriaHook(criteriaDto);
    }

    protected ResponseEntity<Collection<DTO>> retrieveByCriteriaHook(criteriaViewModel criteriaDto) {
        ModelCriteria criteria = this.translator.translateCriteria(criteriaDto);
        List<Model> models = this.service.retrieveByCriteria(criteria);
        Collection<DTO> dtos = this.translator.translateToDTO(models);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}
