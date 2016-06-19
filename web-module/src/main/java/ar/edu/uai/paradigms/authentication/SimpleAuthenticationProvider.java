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

        LOGGER.error("#########################################################");
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        List<Usuario> usuarios = usuarioService.retrieveByUsername(name);
        boolean existe_y_tiene_permisos=false;

        if(usuarios.size()>0)
        {
            LOGGER.error("existe");

            Usuario u = usuarios.get(0);
            if(u.getPassword().equals(password))
            {
                LOGGER.error("y tiene permisos");

                existe_y_tiene_permisos=true;
            }
        }

        LOGGER.error("#########################################################");


        if ( (name.equals("admin") && password.equals("admin")) ||
              existe_y_tiene_permisos)
        {
            List<GrantedAuthority> grants = new ArrayList();
            grants.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new UsernamePasswordAuthenticationToken(name, password, grants);
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


}
