package br.com.digisystem.api.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "endereco")
@EqualsAndHashCode (onlyExplicitlyIncluded = true) //compara valores se são iguais, mas apenas os declarados explicitamente
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include //diz que deve ser comparado a chave primária
	private int id;
	
	//@JsonProperty(value = "rua-do-json")
	//@Column(name = "rua")
	@NotNull
	private String logradouro;
	
	private String numero;
	private String complemento;
	private String cidade;
	private String bairro;
	private String cep;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	@JsonIgnore // não traz as informações do cliente pelo json
	private Cliente cliente;
}
