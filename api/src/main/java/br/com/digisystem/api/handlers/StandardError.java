package br.com.digisystem.api.handlers;

import java.util.Date;

import lombok.Builder;
import lombok.Data;


//criado um objeto com as anotações do lombok que retornará um erro no formato JSON
@Data
@Builder
public class StandardError {

	private String mensagem;
	private int status;
	private Date timestamp;
}
