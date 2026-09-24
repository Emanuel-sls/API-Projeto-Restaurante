package com.restaurante.projeto_milionario.infrastructure.repository;

import com.restaurante.projeto_milionario.infrastructure.entity.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdmiRepository extends JpaRepository<Administrador, Long> {

    Optional<Administrador> findByNomeAdm(String nomeAdm);

}