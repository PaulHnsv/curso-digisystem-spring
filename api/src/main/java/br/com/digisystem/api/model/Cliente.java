package br.com.digisystem.api.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@EqualsAndHashCode (onlyExplicitlyIncluded = true) //compara valores se são iguais, mas apenas os declarados explicitamente
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private int id;
	
	private String nome;
	private String email;
	private String cpf;
	
	//@JsonProperty(access = Access.WRITE_ONLY)
	private String senha;
	
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos;
	
	@ElementCollection
	@CollectionTable ( name = "telefone" )
	private Set<String> telefone = new HashSet<String>();
}
