package ar.edu.uai.paradigms.controller.cliente;

import ar.edu.uai.model.cliente.Cliente;
import ar.edu.uai.model.cliente.ClienteCriteria;
import ar.edu.uai.paradigms.dto.cliente.ClienteCriteriaDTO;
import ar.edu.uai.paradigms.dto.cliente.ClienteDTO;
import ar.edu.uai.paradigms.service.ClienteService;
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
public class ClienteController
{
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ClienteController.class);

    private ClienteService clienteService;

    private ClienteTranslator clienteTranslator;

    public ClienteController( ClienteService clienteService,
                               ClienteTranslator clienteTranslator)
    {
        super();
        this.clienteService = clienteService;
        this.clienteTranslator = clienteTranslator;

    }



    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO clienteDTO) {
        LOGGER.debug("Received DTO: " + clienteDTO);


        Cliente    clienteModel       = this.clienteTranslator   .translate(clienteDTO);
        Cliente    cliente            = this.clienteService      .save(clienteModel);
        ClienteDTO clienteDTOOutput   = this.clienteTranslator   .translateToDTO(cliente);

        return new ResponseEntity<ClienteDTO>(clienteDTOOutput, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ClienteDTO>> retrieveByCriteria(ClienteCriteriaDTO clienteCriteriaDTO) {
        LOGGER.debug("Received QUERY: " + clienteCriteriaDTO);

        ClienteCriteria criteria            = this.clienteTranslator.translateCriteria(clienteCriteriaDTO);
        List<Cliente> clientes              = this.clienteService.retrieveByCriteria(criteria);
        List<ClienteDTO> clienteDTOs        = this.clienteTranslator.translateToDTO(clientes);

        return new ResponseEntity<List<ClienteDTO>>(clienteDTOs, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
    public
    @ResponseBody
    ResponseEntity<ClienteDTO> getClient(@PathVariable Integer identifier) throws InterruptedException {
        Cliente retrievedClient = this.clienteService.retrieve(identifier);
        ClienteDTO client = this.clienteTranslator.translateToDTO(retrievedClient);
        if (client != null) {
            return new ResponseEntity<ClienteDTO>(client, HttpStatus.OK);
        }
        return new ResponseEntity<ClienteDTO>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{identifier}")
    public
    @ResponseBody
    ResponseEntity<String> delete(@PathVariable Integer identifier) {
        this.clienteService.delete(identifier);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
}
