package br.com.digisystem.api.controller;



//import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.digisystem.api.model.Produto;
import br.com.digisystem.api.services.ProdutoService;
import br.com.digisystem.api.services.execption.ObjectNotFoundDigiException;

@RestController
public class ProdutoController {
	
	//int vetorInt[] = new int[10]   Vetor com 10 de espaço
    //List<Produto> listaProduto = new ArrayList<Produto>();
	
    //injeção de dependência
    @Autowired
    private ProdutoService produtoService; //substitui o = new Produto Service
    
	//@RequestMapping(method = RequestMethod.GET, value = "primeiro")
	@GetMapping( value = "produtos")
	public ResponseEntity<List<Produto>> getAll() {
		List <Produto> list = this.produtoService.findAll();
		return ResponseEntity.ok().body(list);
	}

	//Mapeia uma url por alguma váriavel visivel na página principal
	@RequestMapping(value = "produtos/{id_produto}")
	public ResponseEntity<Produto> get(@PathVariable("id_produto") int id_produto) {
		//return this.produtoService.findOne(id_produto).orElse(new Produto( 1000, "Nome", 1000));
		
		Produto p = this.produtoService.findOne(id_produto)
				.orElseThrow( () -> new ObjectNotFoundDigiException("ID do produto não encontrado"));
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
	
	//pega uma requisição via body do JSON
	@PostMapping(value = "produtos")
	public Produto create (@RequestBody Produto produto) {
		System.out.println(produto);
		return this.produtoService.Create(produto);
	}
	
	//altera um produto visivel no JSON
	@PutMapping (value = "produtos/{id_produto}")
	public ResponseEntity<Produto> update(@PathVariable("id_produto") int id_produto,
		   @RequestBody Produto produto){
		return this.produtoService.update(id_produto, produto);
		}
	
	//deleta o produto buscado pelo id
	@DeleteMapping(value = "produtos/{id_produto}")
	public boolean delete(@PathVariable("id_produto") int id_produto) {
		return this.produtoService.delete(id_produto);
	}
	
	//Mapeia uma url por alguma váriavel visivel na página principal utilizando o filtro nome do produto
		@GetMapping(value = "produtos/search/{nome}")
		public List<Produto> getNome(
				@PathVariable("nome") String nome,
				@RequestParam(value = "fcid", defaultValue = "") String fcid
				) {
			System.out.println(fcid);
			return this.produtoService.findByNome(nome);
		}
		
		//@GetMapping( value = "produtos/search/{nome}/{preco}" )
		//public List<Produto> getByName( 			
				//@PathVariable("nome") String nome,
				//@PathVariable("preco") float preco,
				//@RequestParam(value = "fcid", defaultValue = "") String fcid 
			//) {
			//System.out.println( fcid );
			//return this.produtoService.findByNome( nome, preco );		
		//}
		//
		//@GetMapping( value = "produtos/search/{nome}" )
		//public List<Produto> getByNameWithouPreco( 			
				//@PathVariable("nome") String nome,			
				//@RequestParam(value = "fcid", defaultValue = "") String fcid 
			//) {
			//System.out.println( fcid );
			//return this.produtoService.findByNome( nome, 0 );		
		//}
}
