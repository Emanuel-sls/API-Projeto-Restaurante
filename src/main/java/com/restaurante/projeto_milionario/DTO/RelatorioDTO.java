package com.restaurante.projeto_milionario.DTO;

import java.math.BigDecimal;

public record RelatorioDTO(
        Integer totalPedidos,
        BigDecimal faturamentoDoDia,
        Long mesasOcupadas,
        String produtoMaisVendido
) {}
