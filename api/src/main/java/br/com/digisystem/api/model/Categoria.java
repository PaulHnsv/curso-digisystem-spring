package br.com.digisystem.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode ( onlyExplicitlyIncluded = true)
@Builder
@Entity
public class Categoria {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private int id;
	
	private String nome;
	private String descricao;
	
	@ManyToMany( mappedBy = "categorias" )
	@JsonIgnore
	private List<Produto> produtos;
}
