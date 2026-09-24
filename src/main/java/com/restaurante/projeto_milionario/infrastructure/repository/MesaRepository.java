package com.restaurante.projeto_milionario.infrastructure.repository;

import com.restaurante.projeto_milionario.infrastructure.entity.Mesa;
import com.restaurante.projeto_milionario.infrastructure.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MesaRepository extends JpaRepository<Mesa, Integer> {
    Optional<Mesa> findByNumeroMesa(Integer  numeroMesa);

    @Query("SELECT COUNT(m) FROM Mesa m WHERE m.disponivel IN ('OCUPADO', 'AGUARDANDO_GARCOM')")
    Long contarMesasOcupadas();
}
