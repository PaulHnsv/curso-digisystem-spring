package br.com.digisystem.api.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digisystem.api.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, BigInteger> {

}
