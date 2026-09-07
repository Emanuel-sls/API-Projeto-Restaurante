package com.restaurante.projeto_milionario.infrastructure.repository;

import com.restaurante.projeto_milionario.infrastructure.entity.Categoria;
import com.restaurante.projeto_milionario.infrastructure.entity.Produto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository  extends JpaRepository<Produto,Long> {
    Optional<Produto> findByNomeProduto(String nomeProduto);

    Optional<Produto> findById(Integer id);




}
