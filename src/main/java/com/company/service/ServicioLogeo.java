package com.company.service;

import java.io.IOException;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.SoapFaultClientException;

import com.company.servicioweb.serviciologeo.LogeoRequest;
import com.company.servicioweb.serviciologeo.LogeoResponse;

public class ServicioLogeo extends AbstractUserDetailsAuthenticationProvider  {

	public ServicioLogeo() {
	}

	@Resource(name = "webServiceTemplate")
	private WebServiceTemplate webServiceTemplate;

	private MyUserDetailsService myUserDetailsService;

	
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {

	}

	
	@Override
	protected UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {

		LogeoRequest request = new LogeoRequest();
		request.setPasword(authentication.getCredentials().toString());
		myUserDetailsService.setContrasena(authentication.getCredentials().toString()); 
		request.setUsuario(username);
		try {
			LogeoResponse response = (LogeoResponse) webServiceTemplate.marshalSendAndReceive(request);
			if (response.isUsuarioValido()) {
				System.out.println("usuario  valido");
				
				UserDetails user =  myUserDetailsService.loadUserByUsername(username);
				System.out.println("dasdsadsadsadas");
				return user; 
			} else	System.out.println("usuario no vlido");
			return null; 
		} catch (Exception e) {
			System.out.println("excepcion => " + e.getMessage());
			return null;
		}
	}

	public WebServiceTemplate getWebServiceTemplate() {
		return webServiceTemplate;
	}

	public void setWebServiceTemplate(WebServiceTemplate webServiceTemplate) {
		this.webServiceTemplate = webServiceTemplate;
	}

	public MyUserDetailsService getMyUserDetailsService() {
		return myUserDetailsService;
	}

	public void setMyUserDetailsService(
			MyUserDetailsService myUserDetailsService) {
		this.myUserDetailsService = myUserDetailsService;
	}



	

}
