package br.com.digisystem.api.services.execption;

public class ObjectNotFoundDigiException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundDigiException (String mensagem) {
		super(mensagem);
	}

	public ObjectNotFoundDigiException (String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
	
}
