package br.com.digisystem.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Lombok
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Produto {

	@Id //chave primária
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id_produto;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "preco")
	private double preco;
	
}
