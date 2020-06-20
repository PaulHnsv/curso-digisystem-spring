package br.com.digisystem.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.digisystem.api.dto.CredenciaisDTO;
import br.com.digisystem.api.security.AuthToken;
import br.com.digisystem.api.security.CredencialSecurityModel;
import br.com.digisystem.api.security.JWTUtil;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

//@Log fazer um log automático.
@Slf4j //log
@RequestMapping(value = "auth")
@RestController
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTUtil jwtUtil;
	
	@RequestMapping(value = "login", method = { RequestMethod.POST })
	public ResponseEntity<AuthToken> getJwt(@RequestBody CredenciaisDTO credenciais) {

		log.info( credenciais.toString() );
		log.info( credenciais.getSenha()  );

		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(credenciais.getEmail(), credenciais.getSenha()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		/* final String token = jwtTokenUtil.generateToken(authentication); */

		String username = ((CredencialSecurityModel) authentication.getPrincipal()).getUsername();
		String nome = ((CredencialSecurityModel) authentication.getPrincipal()).getNome();

		final String token = jwtUtil.generateToken(username, nome);
		
		log.info( token );

		AuthToken authToken = new AuthToken(token);

		return ResponseEntity.ok(authToken);

	}

}