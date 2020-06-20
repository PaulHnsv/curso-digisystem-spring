package br.com.digisystem.api.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@EqualsAndHashCode ( onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Produto {
	

	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	@EqualsAndHashCode.Include
	private int id;
	
	@ApiModelProperty(name = "nome", required = true)
	private String nome;
	
	private double preco;
	
	@ManyToMany
	@JoinTable ( 
			name="produtos_categorias" ,  
			joinColumns = @JoinColumn ( name ="produto_id"), 
			inverseJoinColumns = @JoinColumn( name = "categoria_id" ) 
		)
	private List<Categoria> categorias;
		
	//lombok
}

