  
package br.com.digisystem.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.digisystem.api.model.Cliente;
import br.com.digisystem.api.repositories.ClienteRepository;
import br.com.digisystem.api.security.CredencialSecurityModel;

@Service
public class CredentialDetailsServiceImpl implements UserDetailsService  {


	@Autowired
	private ClienteService clienteService;
		
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Cliente user = clienteService.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(email);
		}
		return new CredencialSecurityModel(
				 user.getEmail(), user.getSenha(), 
				user.getNome()
					);
	}
}


