package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.usuario.Usuario;

import java.util.List;

/**
 * Created by Skeith on 15/06/2016.
 */
public interface UsuarioService extends Service<Usuario,Integer>
{
    List<Usuario> retrieveByUsername(String username);
}
