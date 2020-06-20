package br.com.digisystem.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.digisystem.api.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
