package mx.gob.tabasco.seguro.services.security;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class AuthenticationImpl implements Authentication {

	private static final long serialVersionUID = 1060351962790594194L;

	private String name;
	private Collection<GrantedAuthority> authorities;
	private Object credentials;
	private Object details;
	private Object principal;
	private boolean authenticated;
	
	public AuthenticationImpl() {
		
	}
	
	public AuthenticationImpl(String name, Collection<GrantedAuthority> authorities, Object credentials,
			Object details, Object principal, boolean authenticated) {
		this.name = name;
		this.authorities = authorities;
		this.credentials = credentials;
		this.details = details;
		this.principal = principal;
		this.authenticated = authenticated;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public Object getCredentials() {
		return credentials;
	}

	@Override
	public Object getDetails() {
		return details;
	}

	@Override
	public Object getPrincipal() {
		return principal;
	}

	@Override
	public boolean isAuthenticated() {
		return authenticated;
	}

	@Override
	public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
		this.authenticated = authenticated;
	}

}
