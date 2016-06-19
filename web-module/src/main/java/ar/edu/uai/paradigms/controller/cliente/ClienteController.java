package ar.edu.uai.paradigms.controller.cliente;

import ar.edu.uai.model.cliente.Cliente;
import ar.edu.uai.model.cliente.ClienteCriteria;
import ar.edu.uai.paradigms.controller.Generics.BaseController;
import ar.edu.uai.paradigms.dto.cliente.ClienteCriteriaDTO;
import ar.edu.uai.paradigms.dto.cliente.ClienteDTO;
import ar.edu.uai.paradigms.service.ClienteService;
import ar.edu.uai.paradigms.translator.Generics.Translator;
import ar.edu.uai.paradigms.translator.cliente.ClienteTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Skeith on 20/05/2016.
 */

@Controller
@RequestMapping("/clients")
public class ClienteController extends BaseController<ClienteDTO, ClienteCriteriaDTO>
{
    public ClienteController( ClienteService clienteService,
                               ClienteTranslator clienteTranslator)
    {
        super(clienteService, (Translator) clienteTranslator);

    }
}
