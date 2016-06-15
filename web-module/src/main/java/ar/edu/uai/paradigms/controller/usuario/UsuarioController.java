package ar.edu.uai.paradigms.controller.usuario;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.cliente.Cliente;
import ar.edu.uai.model.cliente.ClienteCriteria;
import ar.edu.uai.model.usuario.Usuario;
import ar.edu.uai.model.usuario.UsuarioCriteria;
import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.dto.cliente.ClienteCriteriaDTO;
import ar.edu.uai.paradigms.dto.cliente.ClienteDTO;
import ar.edu.uai.paradigms.dto.usuario.UsuarioCriteriaDTO;
import ar.edu.uai.paradigms.dto.usuario.UsuarioDTO;
import ar.edu.uai.paradigms.service.ClienteService;
import ar.edu.uai.paradigms.service.Service;
import ar.edu.uai.paradigms.service.UsuarioService;
import ar.edu.uai.paradigms.translator.Generics.Translator;
import ar.edu.uai.paradigms.translator.cliente.ClienteTranslator;
import ar.edu.uai.paradigms.translator.usuario.UsuarioTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Skeith on 15/06/2016.
 */
@Controller
@RequestMapping("/users")
public class UsuarioController
{
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UsuarioController.class);

    private UsuarioService usuarioService;

    private UsuarioTranslator usuarioTranslator;

    public UsuarioController( UsuarioService usuarioService,
                              UsuarioTranslator usuarioTranslator)
    {
        super();
        this.usuarioService = usuarioService;
        this.usuarioTranslator = usuarioTranslator;

    }

    @ExceptionHandler(Exception.class)
    public void handleExceptions(Exception anExc) {
        anExc.printStackTrace(); // do something better than this ;)
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuarioDTO) {
        LOGGER.debug("Received DTO: " + usuarioDTO);
        LOGGER.error("#######################################################");
        LOGGER.error("#######################################################");

        Usuario usuarioModel          = this.usuarioTranslator   .translate(usuarioDTO);
        Usuario    usuario            = this.usuarioService      .save(usuarioModel);
        UsuarioDTO usuarioDTOOutput   = this.usuarioTranslator   .translateToDTO(usuario);

        return new ResponseEntity<UsuarioDTO>(usuarioDTOOutput, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UsuarioDTO>> retrieveByCriteria(UsuarioCriteriaDTO usuarioCriteriaDTO) {
        LOGGER.debug("Received QUERY: " + usuarioCriteriaDTO);


        UsuarioCriteria criteria            = this.usuarioTranslator.translateCriteria(usuarioCriteriaDTO);
        List<Usuario> usuarios              = this.usuarioService.retrieveByCriteria(criteria);
        List<UsuarioDTO> usuarioDTOs        = this.usuarioTranslator.translateToDTO(usuarios);

        return new ResponseEntity<List<UsuarioDTO>>(usuarioDTOs, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
    public
    @ResponseBody
    ResponseEntity<UsuarioDTO> getClient(@PathVariable Integer identifier) throws InterruptedException {
        Usuario retrievedUser = this.usuarioService.retrieve(identifier);
        UsuarioDTO usuario = this.usuarioTranslator.translateToDTO(retrievedUser);
        if (usuario != null) {
            return new ResponseEntity<UsuarioDTO>(usuario, HttpStatus.OK);
        }
        return new ResponseEntity<UsuarioDTO>(HttpStatus.NO_CONTENT);
    }

}