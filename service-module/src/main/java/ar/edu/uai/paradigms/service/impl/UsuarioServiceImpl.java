package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.usuario.Usuario;
import ar.edu.uai.paradigms.dao.UsuarioDAO;
import ar.edu.uai.paradigms.service.UsuarioService;

import java.util.List;

/**
 * Created by Skeith on 15/06/2016.
 */
public class UsuarioServiceImpl extends ServiceImpl<Usuario,Integer> implements UsuarioService{

    UsuarioDAO usuarioDAO;
    public UsuarioServiceImpl(UsuarioDAO usuarioDAO)
    {
        super(usuarioDAO);
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public List<Usuario> retrieveByUsername(String username)
    {
        return  usuarioDAO.retrieveByUsername(username);
    }



}
