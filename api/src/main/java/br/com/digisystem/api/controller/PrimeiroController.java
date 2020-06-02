package br.com.digisystem.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {

	//@RequestMapping(method = RequestMethod.GET, value = "primeiro")
	@GetMapping( value = "primeiro")
	public String helloWord() {
		return "Hello Word!!";
		
	}
}
