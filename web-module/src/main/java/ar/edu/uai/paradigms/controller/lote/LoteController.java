package ar.edu.uai.paradigms.controller.lote;

import ar.edu.uai.model.lote.Lote;
import ar.edu.uai.model.lote.LoteCriteria;
import ar.edu.uai.model.producto.Producto;
import ar.edu.uai.paradigms.dto.lote.LoteCriteriaDTO;
import ar.edu.uai.paradigms.dto.lote.LoteDTO;
import ar.edu.uai.paradigms.service.LoteService;
import ar.edu.uai.paradigms.service.ProductoService;
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
@RequestMapping("/products/{productID}/batches")
public class LoteController {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(LoteController.class);

    private LoteService loteService;
    private ProductoService productoService;

    private LoteTranslator loteTranslator;

    public LoteController( LoteService loteService, LoteTranslator loteTranslator, ProductoService productoService)
    {
        super();
        this.loteService = loteService;
        this.loteTranslator = loteTranslator;
        this.productoService = productoService;
    }



    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<LoteDTO> create(@RequestBody LoteDTO loteDTO,
                                          @PathVariable Integer productID) {
        //LOGGER.debug("Received DTO: " + loteDTO);

        Producto prod = productoService.retrieve(productID);


        Lote loteModel          = this.loteTranslator.translate(loteDTO, prod);

        
        Lote lote               = this.loteService.save(loteModel);
        LoteDTO loteDTOOutput   = this.loteTranslator.translateToDTO(lote,prod);

        return new ResponseEntity<LoteDTO>(loteDTOOutput, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<LoteDTO>> retrieveByCriteria(LoteCriteriaDTO loteCriteria,
                                                            @PathVariable Integer productID) {
        LOGGER.debug("Received QUERY: " + loteCriteria);
        Producto prod = productoService.retrieve(productID);

        List<LoteDTO> lotesDTOs = this.loteTranslator.translateToDTO(prod.getLotes(),prod);
        return new ResponseEntity<List<LoteDTO>>(lotesDTOs, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{batchID}")
    @ResponseBody
    public ResponseEntity<LoteDTO> getLote(@PathVariable Integer productID,
                                           @PathVariable Integer batchID) throws InterruptedException {
        Lote retrievedLote  = this.loteService.retrieve(batchID);
        Producto prod       = this.productoService.retrieve(productID);

        LoteDTO loteDTO = this.loteTranslator.translateToDTO(retrievedLote, prod);
        if (loteDTO != null) {
            return new ResponseEntity<LoteDTO>(loteDTO, HttpStatus.OK);
        }
        return new ResponseEntity<LoteDTO>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{batchID}")
    @ResponseBody
    public ResponseEntity<String> delete(@PathVariable Integer batchID) {
        this.loteService.delete(batchID);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
}
