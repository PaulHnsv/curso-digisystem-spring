package br.com.digisystem.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.digisystem.api.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
