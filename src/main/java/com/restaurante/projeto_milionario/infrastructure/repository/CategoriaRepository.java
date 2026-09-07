package com.restaurante.projeto_milionario.infrastructure.repository;

import com.restaurante.projeto_milionario.infrastructure.entity.Categoria;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository  extends JpaRepository<Categoria,Long> {
    Optional<Categoria> findByNomeCategoria(String nomeCategoria );



    Optional<Categoria> findById(Integer id);
}
