package mx.gob.tabasco.seguro.services.security;

import java.util.ArrayList;

import mx.gob.tabasco.seguro.entities.Usuario;
import mx.gob.tabasco.seguro.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthenticationProviderImpl implements AuthenticationProvider {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String nombreUsuario = auth.getPrincipal().toString();
		String password = auth.getCredentials().toString();
		
		Usuario usuario = usuarioRepository.getByUsuarioAndPassword(nombreUsuario, password);
		
		if (null == usuario) {
			throw new UsernameNotFoundException("El usuario / contraseña son incorrectos.");
		}
		
		return new AuthenticationImpl(usuario.getUsuario(), new ArrayList<GrantedAuthority>(), 
				usuario.getPassword(), usuario, usuario.getUsuario(), true);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
