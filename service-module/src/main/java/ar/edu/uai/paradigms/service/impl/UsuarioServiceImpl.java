package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.usuario.Usuario;
import ar.edu.uai.paradigms.dao.UsuarioDAO;
import ar.edu.uai.paradigms.service.UsuarioService;

/**
 * Created by Skeith on 15/06/2016.
 */
public class UsuarioServiceImpl extends ServiceImpl<Usuario,Integer> implements UsuarioService{

    public UsuarioServiceImpl(UsuarioDAO usuarioDAO)
    {
        super(usuarioDAO);
    }
}
