package br.com.digisystem.api.teste;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.bind.annotation.RestController;

import br.com.digisystem.api.model.Produto;
import br.com.digisystem.api.repositories.ProdutoRepository;
import br.com.digisystem.api.services.ProdutoService;


@RestController
@RunWith(MockitoJUnitRunner.class)
public class ProdutoServiceTeste {

	@Mock
	private ProdutoRepository produtoRepository;
	
	@InjectMocks
	private ProdutoService produtoService;
	
	@InjectMocks
	private Optional<Produto> produto;
	
	@Test
	public void procuraUM(int id) {
		id = 1;
		when(produtoService.findOne(id)).thenReturn(produto);
		verify(produtoRepository, times(1));
	}
	

	@Test
	public void deletaUm(int id) {
		id = 1;
		this.produtoService.delete(id);
		verify(produtoRepository, times(1));
	}
	

}
