package br.com.digisystem.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import br.com.digisystem.api.model.Produto;
import br.com.digisystem.api.repositories.ProdutoRepository;

public class PopularBancoService {


	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Value("${mode}")
	private String mode;
	
	public void criarMassaDados() {
	
	if (this.mode.contains("dev")) {
		
		Produto p1 = Produto
				.builder()
				.nome("Produto 1")
				.preco(550)
				.build();
		this.produtoRepository.save(p1);
		}
	}

}
