package br.com.digisystem.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digisystem.api.dto.ClienteDTO;
import br.com.digisystem.api.model.Cliente;
import br.com.digisystem.api.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository; 

	public List<ClienteDTO> findAll(){
		/* Convertendo Cliente para ClienteDTO */
		
		List <Cliente> listCliente = this.clienteRepository.findAll();
		
		List<ClienteDTO> listClientDto = new ArrayList<ClienteDTO>();
		
		for ( Cliente cli : listCliente  ) {
			ClienteDTO clienteDto = ClienteDTO
					.builder()
					.cpf( cli.getCpf() )
					.email( cli.getEmail() )
					.id( cli.getId() )
					.nome( cli.getNome() )
					.build();
			
			listClientDto.add( clienteDto );
		}
		return listClientDto;						 
	}

	public Cliente findByEmail(String email) {
		return this.clienteRepository.findByEmail(email);
	}

}
