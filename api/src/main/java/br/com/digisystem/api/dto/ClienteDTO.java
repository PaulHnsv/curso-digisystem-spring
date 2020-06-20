package br.com.digisystem.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDTO {

	private int id;
	private String nome;
	private String email;
	private String cpf;
}
