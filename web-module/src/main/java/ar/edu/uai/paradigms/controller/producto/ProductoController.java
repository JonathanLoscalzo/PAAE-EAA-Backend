package ar.edu.uai.paradigms.controller.producto;


import ar.edu.uai.model.producto.Producto;
import ar.edu.uai.model.producto.ProductoCriteria;
import ar.edu.uai.paradigms.dto.producto.ProductoCriteriaDTO;
import ar.edu.uai.paradigms.dto.producto.ProductoDTO;
import ar.edu.uai.paradigms.service.ProductoService;
import ar.edu.uai.paradigms.translator.producto.ProductoTranslator;
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
@RequestMapping("/products")
public class ProductoController {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(ProductoController.class);

    private ProductoService productoService;

    private ProductoTranslator productoTranslator;

    public ProductoController( ProductoService productoService, ProductoTranslator productoTranslator) {
        super();
        this.productoService = productoService;
        this.productoTranslator = productoTranslator;
    }



    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<ProductoDTO> create(@RequestBody ProductoDTO productoDTO) {
        LOGGER.debug("Received DTO: " + productoDTO);

        Producto productoModel          = this.productoTranslator.translate(productoDTO);
        Producto producto               = this.productoService.save(productoModel);
        ProductoDTO productoDTOOutput   = this.productoTranslator.translateToDTO(producto);

        return new ResponseEntity<ProductoDTO>(productoDTOOutput, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<List<ProductoDTO>> retrieveByCriteria(ProductoCriteriaDTO productoCriteria) {
        LOGGER.debug("Received QUERY: " + productoCriteria);

        ProductoCriteria criteria           = this.productoTranslator.translateCriteria(productoCriteria);
        List<Producto> productos            = this.productoService.retrieveByCriteria(criteria);
        List<ProductoDTO> productosDTOs     = this.productoTranslator.translateToDTO(productos);

        return new ResponseEntity<List<ProductoDTO>>(productosDTOs, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
    public
    @ResponseBody
    ResponseEntity<ProductoDTO> getProduct(@PathVariable Integer identifier) throws InterruptedException {
        Producto retrievedProduct = this.productoService.retrieveProducto(identifier);
        ProductoDTO product = this.productoTranslator.translateToDTO(retrievedProduct);
        if (product != null) {
            return new ResponseEntity<ProductoDTO>(product, HttpStatus.OK);
        }
        return new ResponseEntity<ProductoDTO>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{identifier}")
    public
    @ResponseBody
    ResponseEntity<String> delete(@PathVariable Integer identifier) {
        this.productoService.deleteProducto(identifier);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
}
