package br.com.digisystem.api.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.digisystem.api.model.Produto;
import br.com.digisystem.api.repositories.ProdutoRepository;

@Service
public class ProdutoService{

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> findAll() {
		return this.produtoRepository.findAll();
	}
	
	public Produto Create (Produto produto) {
		return this.produtoRepository.save(produto);
	}
	
	
	// o Optinal da novas maneiras de se tratar erros com o select
	public java.util.Optional<Produto> findOne (int id) {
		return (java.util.Optional<Produto>) this.produtoRepository.findById(id);
		//return this.produtoRepository.findById(id).get();
	}
	
	//public void delete(int id) {
	//	this.produtoRepository.deleteById(id);
	//}
	
	
	public boolean delete(int id) {
		this.produtoRepository.deleteById(id);
		return true;
	}
	
	// essa forma é a melhor para grandes volumes de dados
	//mapreduce é o .map o record é o nome dado para que eu manipule cada entrada do vetor
	public ResponseEntity<Produto> update(int id, @RequestBody Produto produto) {
		return this.produtoRepository.findById(id)
		.map(record -> {
			record.setNome(produto.getNome());
            record.setPreco(produto.getPreco());
            Produto updated = produtoRepository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
	}
	
	//essa forma é melhor para pequenos grupos de informações
	//public Produto update(int id, Produto prod) {
		//Optional<Produto> search = this.produtoRepository.findById(id);
		//
		//if ( search.isPresent() ) {
		//	Produto p = search.get();
		//	p.setNome( prod.getNome()  );
		//	p.setPreco( prod.getPreco() );
		//	
		//	return this.produtoRepository.save( p );
		//}			
		//
		//return null;
	//}

	public List<Produto> findByNome( String nome ) {
		return this.produtoRepository.findByNomeContains(nome);
	}
	
}
