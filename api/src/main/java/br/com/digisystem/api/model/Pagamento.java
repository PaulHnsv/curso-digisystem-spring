package br.com.digisystem.api.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private int id;
	
	private Date dataPagamento;
	
	private double valor;
	
	@OneToOne(mappedBy = "pagamento", cascade = CascadeType.ALL) //anotação de referença para a chave estrangeira da tabela pagamento
	private Pedido pedido;
}
