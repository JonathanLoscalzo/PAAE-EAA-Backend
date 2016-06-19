package ar.edu.uai.paradigms.controller.usuario;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.cliente.Cliente;
import ar.edu.uai.model.cliente.ClienteCriteria;
import ar.edu.uai.model.usuario.Usuario;
import ar.edu.uai.model.usuario.UsuarioCriteria;
import ar.edu.uai.paradigms.controller.Generics.BaseController;
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
@RequestMapping("/users")
public class UsuarioController extends BaseController<UsuarioDTO, UsuarioCriteriaDTO>
{
    public UsuarioController( UsuarioService usuarioService,
                              UsuarioTranslator usuarioTranslator)
    {
        super(usuarioService, usuarioTranslator);
    }
}