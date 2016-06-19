package ar.edu.uai.paradigms.controller.lote;

import ar.edu.uai.model.lote.Lote;
import ar.edu.uai.model.lote.LoteCriteria;
import ar.edu.uai.model.producto.Producto;
import ar.edu.uai.paradigms.controller.Generics.BaseController;
import ar.edu.uai.paradigms.dto.DTO;
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

import java.util.Collection;
import java.util.List;

/**
 * Created by Hal on 18/04/2016.
 */
@Controller
@RequestMapping("/products/{productID}/batches")
public class LoteController extends BaseController<LoteDTO, LoteCriteriaDTO>{

    private static final Logger LOGGER = LoggerFactory
            .getLogger(LoteController.class);
    private ProductoService productoService;

    public LoteController( LoteService loteService, LoteTranslator loteTranslator, ProductoService productoService)
    {
        super(loteService, loteTranslator);
        this.productoService = productoService;
    }

    @Override
    protected ResponseEntity<LoteDTO> createHook(@RequestBody LoteDTO dto) {
        Producto prod = productoService.retrieve(dto.getProduct_id());
        Lote loteModel          = ((LoteTranslator)this.translator).translate(dto, prod);
        Lote lote               = (Lote) this.service.save(loteModel);
        LoteDTO loteDTOOutput   = ((LoteTranslator)this.translator).translateToDTO(lote,prod);

        return new ResponseEntity<LoteDTO>(loteDTOOutput, HttpStatus.CREATED);
    }

    //TODO enviar el productID dentro del loteDTO (como producto y proveedor)
    @RequestMapping(value="/new", method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    ResponseEntity<LoteDTO> create(@RequestBody LoteDTO loteDTO,
                                          @PathVariable Integer productID) {
        Producto prod = productoService.retrieve(productID);
        Lote loteModel          = ((LoteTranslator)this.translator).translate(loteDTO, prod);
        Lote lote               = (Lote) this.service.save(loteModel);
        LoteDTO loteDTOOutput   = ((LoteTranslator)this.translator).translateToDTO(lote,prod);
        return new ResponseEntity<LoteDTO>(loteDTOOutput, HttpStatus.CREATED);
    }

    //TODO ( no se puede meter ese productID dentro de criteria ? )
    @RequestMapping(method = RequestMethod.GET, value = "/get/{batchID}")
    @ResponseBody
    public ResponseEntity<LoteDTO> getLote(@PathVariable Integer productID,
                                           @PathVariable Integer batchID) throws InterruptedException {
        Lote retrievedLote  = (Lote) this.service.retrieve(batchID);
        Producto prod       = this.productoService.retrieve(productID);
        LoteDTO loteDTO = ((LoteTranslator)this.translator).translateToDTO(retrievedLote, prod);
        if (loteDTO != null) {
            return new ResponseEntity<LoteDTO>(loteDTO, HttpStatus.OK);
        }
        return new ResponseEntity<LoteDTO>(HttpStatus.NO_CONTENT);
    }
}
