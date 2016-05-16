package ar.edu.uai.paradigms.controller.lote;

import ar.edu.uai.model.lote.Lote;
import ar.edu.uai.model.lote.LoteCriteria;
import ar.edu.uai.paradigms.dto.lote.LoteCriteriaDTO;
import ar.edu.uai.paradigms.dto.lote.LoteDTO;
import ar.edu.uai.paradigms.service.LoteService;
import ar.edu.uai.paradigms.translator.lote.LoteTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Hal on 18/04/2016.
 */
@Controller
@RequestMapping("/productos/{identifier}/lotes")
public class LoteController {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(LoteController.class);

    private LoteService loteService;

    private LoteTranslator loteTranslator;

    public LoteController( LoteService loteService, LoteTranslator loteTranslator)
    {
        super();
        this.loteService = loteService;
        this.loteTranslator = loteTranslator;
    }



    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<LoteDTO> create(@RequestBody LoteDTO loteDTO) {
        LOGGER.debug("Received DTO: " + loteDTO);

        Lote loteModel          = this.loteTranslator.translate(loteDTO);
        Lote lote               = this.loteService.saveLote(loteModel);
        LoteDTO loteDTOOutput   = this.loteTranslator.translateToDTO(lote);

        return new ResponseEntity<LoteDTO>(loteDTOOutput, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<LoteDTO>> retrieveByCriteria(LoteCriteriaDTO loteCriteria) {
        LOGGER.debug("Received QUERY: " + loteCriteria);
        LoteCriteria criteria = this.loteTranslator.translateCriteria(loteCriteria);
        List<Lote> lotes = this.loteService.retrieveByCriteria(criteria);
        List<LoteDTO> lotesDTOs = this.loteTranslator.translateToDTO(lotes);
        return new ResponseEntity<List<LoteDTO>>(lotesDTOs, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
    @ResponseBody
    public ResponseEntity<LoteDTO> getLote(@PathVariable Integer identifier) throws InterruptedException {
        Lote retrievedLote = this.loteService.retrieveLote(identifier);
        LoteDTO lote = this.loteTranslator.translateToDTO(retrievedLote);
        if (lote != null) {
            return new ResponseEntity<LoteDTO>(lote, HttpStatus.OK);
        }
        return new ResponseEntity<LoteDTO>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{identifier}")
    @ResponseBody
    public ResponseEntity<String> delete(@PathVariable Integer identifier) {
        this.loteService.deleteLote(identifier);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
}
