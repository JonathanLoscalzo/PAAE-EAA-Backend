package ar.edu.uai.paradigms.controller.proveedor;

import ar.edu.uai.model.proveedor.Proveedor;
import ar.edu.uai.model.proveedor.ProveedorCriteria;
import ar.edu.uai.paradigms.dto.proveedor.ProveedorCriteriaDTO;
import ar.edu.uai.paradigms.dto.proveedor.ProveedorDTO;
import ar.edu.uai.paradigms.service.ProveedorService;
import ar.edu.uai.paradigms.translator.proveedor.ProveedorTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Skeith on 19/05/2016.
 */
@Controller
@RequestMapping("/suppliers")
public class ProveedorController
{
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ProveedorController.class);

    private ProveedorService proveedorService;

    private ProveedorTranslator proveedorTranslator;

    public ProveedorController( ProveedorService proveedorService, ProveedorTranslator proveedorTranslator) {
        super();
        this.proveedorService = proveedorService;
        this.proveedorTranslator = proveedorTranslator;
    }



    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<ProveedorDTO> create(@RequestBody ProveedorDTO proveedorDTO) {
        LOGGER.debug("Received DTO: " + proveedorDTO);

        Proveedor proveedorModel          = this.proveedorTranslator.translate(proveedorDTO);
        Proveedor proveedor               = this.proveedorService.save(proveedorModel);
        ProveedorDTO proveedorDTOOutput   = this.proveedorTranslator.translateToDTO(proveedor);

        return new ResponseEntity<ProveedorDTO>(proveedorDTOOutput, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<List<ProveedorDTO>> retrieveByCriteria(ProveedorCriteriaDTO proveedorCriteria) {
        LOGGER.debug("Received QUERY: " + proveedorCriteria);

        ProveedorCriteria criteria            = this.proveedorTranslator.translateCriteria(proveedorCriteria);
        List<Proveedor> proveedores            = this.proveedorService.retrieveByCriteria(criteria);
        List<ProveedorDTO> proveedoresDTO      = this.proveedorTranslator.translateToDTO(proveedores);

        return new ResponseEntity<List<ProveedorDTO>>(proveedoresDTO, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
    public
    @ResponseBody
    ResponseEntity<ProveedorDTO> getSupplier(@PathVariable Integer identifier) throws InterruptedException {
        Proveedor retrievedSupplier = this.proveedorService.retrieve(identifier);
        ProveedorDTO proveedorDTO = this.proveedorTranslator.translateToDTO(retrievedSupplier);
        if (proveedorDTO != null)
        {
            return new ResponseEntity<ProveedorDTO>(proveedorDTO, HttpStatus.OK);
        }
        return new ResponseEntity<ProveedorDTO>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{identifier}")
    public
    @ResponseBody
    ResponseEntity<String> delete(@PathVariable Integer identifier) {
        this.proveedorService.delete(identifier);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
}
