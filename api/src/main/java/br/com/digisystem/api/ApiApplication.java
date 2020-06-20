package br.com.digisystem.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.digisystem.api.model.Categoria;
import br.com.digisystem.api.model.Cliente;
import br.com.digisystem.api.model.Endereco;
import br.com.digisystem.api.model.Pagamento;
import br.com.digisystem.api.model.Pedido;
import br.com.digisystem.api.model.Produto;
import br.com.digisystem.api.repositories.CategoriaRepository;
import br.com.digisystem.api.repositories.ClienteRepository;
import br.com.digisystem.api.repositories.EnderecoRepository;
import br.com.digisystem.api.repositories.PagamentoRepository;
import br.com.digisystem.api.repositories.PedidoRepository;
import br.com.digisystem.api.repositories.ProdutoRepository;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner{

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		ArrayList<String> telefones = new ArrayList<String>();
		telefones.add("11-982739845");
		telefones.add( "11-989298767");
		
			Produto p1 = Produto
					.builder()
					.nome("Produto 1")
					.preco(550)
					.build();
			
			Produto p2 = Produto
					.builder()
					.nome("Produto 2")
					.preco(660)
					.build();
			
			Categoria cat1 = Categoria
					.builder()
					.nome("Categoria 1")
					.descricao("É a categoria 1")
					.build();
			
			Categoria cat2 = Categoria
					.builder()
					.nome("Categoria 2")
					.descricao("É a categoria 2")
					.build();
			
			p1.setCategorias(Arrays.asList(cat1, cat2));
			p2.setCategorias(Arrays.asList(cat2));
			
			cat1.setProdutos(Arrays.asList(p1));
			cat2.setProdutos(Arrays.asList(p1, p2));
			
			Cliente cli1 = Cliente
					.builder()
					.cpf("123.456.789-01")
					.email("cliente@Springboot.com.br")
					.nome("Cliente 1")
					.senha( this.bCryptPasswordEncoder.encode( "123456" ) )
					.telefone(new HashSet<>( telefones ) )
					.build();
			
			Endereco end1 = Endereco
					.builder()
					.logradouro("Avenida Paulista")
					.bairro("Bela Vista")
					.numero("1159")
					.complemento("1 Andar")
					.cidade("São Paulo")
					.cep("01311-200")
					.cliente(cli1)
					.build();
			
			Endereco end2 = Endereco
					.builder()
					.logradouro("Avenida Oscar Freire")
					.bairro("Bela Vista")
					.numero("1160")
					.complemento("4 Andar")
					.cidade("São Paulo")
					.cep("01311-066")
					.cliente(cli1)
					.build();
					
			cli1.setEnderecos(Arrays.asList(end1, end2));
			
			Pedido ped1 = Pedido
					.builder()
					.dataPedido(new Date())
					.build();
			
			Pagamento pag1 = Pagamento
					.builder()
					.valor(1000)
					.dataPagamento(new Date())
					.pedido(ped1)
					.build();
			
			ped1.setPagamento(pag1);
			
			this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
			this.pagamentoRepository.save(pag1); //o mais forte da relação primeiro
			this.pedidoRepository.save(ped1);
			this.produtoRepository.saveAll(Arrays.asList(p1, p2));
			this.clienteRepository.save(cli1);
			//linha de baixo salva tudo que for passado no arrays.list
			this.enderecoRepository.saveAll(Arrays.asList(end1, end2));
			}
		}

