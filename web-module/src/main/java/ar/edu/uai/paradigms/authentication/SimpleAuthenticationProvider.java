package ar.edu.uai.paradigms.authentication;

import ar.edu.uai.model.usuario.Usuario;
import ar.edu.uai.paradigms.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Federico on 24/03/2015.
 */
public class SimpleAuthenticationProvider implements AuthenticationProvider {

    UsuarioService usuarioService;


    public SimpleAuthenticationProvider (UsuarioService usuarioService)
    {
        this.usuarioService = usuarioService;
    }


    private static final Logger LOGGER = LoggerFactory
            .getLogger(SimpleAuthenticationProvider.class);


    @Override
    public Authentication authenticate(Authentication authentication)
    {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        Usuario usuario = getUsuario(name,password);


        if ( usuario != null)
        {
            List<GrantedAuthority> grants = new ArrayList();
            LOGGER.error("###########################################################");
            LOGGER.error(usuario.getUsername());
            LOGGER.error(usuario.getRole());
            LOGGER.error("###########################################################");

            grants.add(new SimpleGrantedAuthority(usuario.getRole()));
            return new UsernamePasswordAuthenticationToken(name, password, grants);
        } else {
            return null;
        }
    }

    Usuario getUsuario(String username, String password)
    {
        Usuario u = null;
        List<Usuario> usuarios = usuarioService.retrieveByUsername(username);
        if(usuarios.size()>0)
        {
            u = usuarios.get(0);
        }
        else
        {
            if(username.equals("admin") && password.equals("admin")){
                u = new Usuario(-1,"admin","admin","ROLE_ADMIN");
            }
            if(username.equals("pepe") && password.equals("pepe")){
                u = new Usuario(-1,"pepe","pepe","ROLE_EMPLOYEE");
            }
        }
        // si el usuario no existe ni es admin, retornamos null
        return u;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


}
