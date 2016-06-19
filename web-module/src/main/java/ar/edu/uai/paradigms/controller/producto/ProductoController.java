package ar.edu.uai.paradigms.controller.producto;


import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.producto.Producto;
import ar.edu.uai.model.proveedor.Proveedor;
import ar.edu.uai.paradigms.controller.Generics.BaseController;
import ar.edu.uai.paradigms.dto.producto.ProductoCriteriaDTO;
import ar.edu.uai.paradigms.dto.producto.ProductoDTO;
import ar.edu.uai.paradigms.service.ProductoService;
import ar.edu.uai.paradigms.service.ProveedorService;
import ar.edu.uai.paradigms.translator.producto.ProductoTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Hal on 18/04/2016.
 */
@Controller
@RequestMapping("/products")
public class ProductoController extends BaseController<ProductoDTO, ProductoCriteriaDTO> {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(ProductoController.class);

    private ProveedorService proveedorService;

    public void setProveedorService(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    public ProductoController( ProductoService productoService,
                               ProductoTranslator productoTranslator)
    {
        super(productoService, productoTranslator);
    }

    protected ResponseEntity<ProductoDTO> createHook(ProductoDTO productoDTO) {
        LOGGER.debug("Received DTO: " + productoDTO);

        Proveedor   proveedor           = this.proveedorService     .retrieve(productoDTO.getSupplier_id());
        Producto    productoModel       = (Producto) ((ProductoTranslator)translator).translate(productoDTO, proveedor);
        Producto    producto            = (Producto) this.service      .save(productoModel);
        ProductoDTO productoDTOOutput   = (ProductoDTO) this.translator   .translateToDTO(producto);

        return new ResponseEntity<ProductoDTO>(productoDTOOutput, HttpStatus.CREATED);
    }
}
