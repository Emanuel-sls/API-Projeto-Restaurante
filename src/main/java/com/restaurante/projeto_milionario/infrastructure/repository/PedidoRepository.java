package com.restaurante.projeto_milionario.infrastructure.repository;

import com.restaurante.projeto_milionario.infrastructure.entity.Mesa;
import com.restaurante.projeto_milionario.infrastructure.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    Optional<Pedido> findById(Integer  id);

    @Query("SELECT p FROM Pedido p WHERE p.dataPedido >= :inicio")
    List<Pedido> buscarPedidosDesde(@Param("inicio") LocalDateTime inicio);
}
