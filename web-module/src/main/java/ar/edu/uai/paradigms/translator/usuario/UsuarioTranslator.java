package ar.edu.uai.paradigms.translator.usuario;

import ar.edu.uai.model.usuario.Usuario;
import ar.edu.uai.model.usuario.UsuarioCriteria;
import ar.edu.uai.paradigms.dto.usuario.UsuarioCriteriaDTO;
import ar.edu.uai.paradigms.dto.usuario.UsuarioDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skeith on 15/06/2016.
 */
public class UsuarioTranslator {
    public Usuario translate(UsuarioDTO usuarioDTO)
    {
        return new Usuario (usuarioDTO.getId(),
                usuarioDTO.getUsername(),
                usuarioDTO.getPassword());
    }

    public UsuarioDTO translateToDTO(Usuario usuario)
    {
        if (usuario != null)
        {
            return new UsuarioDTO( usuario.getId(),
                    usuario.getUsername(),
                    usuario.getPassword());
        }
        return null;
    }

    public List<UsuarioDTO> translateToDTO(List<Usuario> usuarios) {
        List<UsuarioDTO> usuarioResponse = new ArrayList<UsuarioDTO>();
        for(Usuario i : usuarios) {
            UsuarioDTO usuarioDTO = this.translateToDTO(i);
            if(usuarioDTO != null) {
                usuarioResponse.add(usuarioDTO);
            }
        }
        return usuarioResponse;
    }

    public UsuarioCriteria translateCriteria(UsuarioCriteriaDTO usuarioCriteriaDTO) {
        return new UsuarioCriteria("admin");
    }
}
