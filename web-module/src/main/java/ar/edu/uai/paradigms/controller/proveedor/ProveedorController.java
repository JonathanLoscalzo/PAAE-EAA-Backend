package ar.edu.uai.paradigms.controller.proveedor;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.proveedor.Proveedor;
import ar.edu.uai.model.proveedor.ProveedorCriteria;
import ar.edu.uai.paradigms.controller.Generics.BaseController;
import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.dto.proveedor.ProveedorCriteriaDTO;
import ar.edu.uai.paradigms.dto.proveedor.ProveedorDTO;
import ar.edu.uai.paradigms.service.ProveedorService;
import ar.edu.uai.paradigms.service.Service;
import ar.edu.uai.paradigms.translator.Generics.Translator;
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
public class ProveedorController extends BaseController<ProveedorDTO, ProveedorCriteriaDTO>
{
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ProveedorController.class);

    private ProveedorService proveedorService;

    private ProveedorTranslator proveedorTranslator;

    public ProveedorController(Service service, Translator translator) {
        super(service, translator);
    }
}
