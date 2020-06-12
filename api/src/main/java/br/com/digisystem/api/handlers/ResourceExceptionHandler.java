package br.com.digisystem.api.handlers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import br.com.digisystem.api.services.execption.ObjectNotFoundDigiException;

@RestControllerAdvice
public class ResourceExceptionHandler {

	// aqui capturamos a eecption tratada na classe ObjectNotFoundDigiException
	@ExceptionHandler ( ObjectNotFoundDigiException.class )
	public ResponseEntity <StandardError> objectNotFound( ObjectNotFoundDigiException ex, HttpServletRequest http) {
	//estamos retornando um ResponseEntity do tipo StandardError	
		StandardError se = StandardError
				.builder()
				.mensagem( ex.getMessage() )
				.status( HttpStatus.NOT_FOUND.value() )
				.timestamp( new Date() )
				.build(); //estudar estrutura do builder
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(se);
		// pegamos na linha acima o tipo de erro que deverá ser retornado no corpo do status
	}
}
