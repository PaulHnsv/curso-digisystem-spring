package br.com.digisystem.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.digisystem.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	Cliente findByEmail(String email);

}
