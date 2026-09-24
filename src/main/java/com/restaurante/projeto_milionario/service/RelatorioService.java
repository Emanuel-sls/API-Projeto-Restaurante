package com.restaurante.projeto_milionario.service;

import com.restaurante.projeto_milionario.DTO.RelatorioDTO;
import com.restaurante.projeto_milionario.infrastructure.entity.ItemPedido;
import com.restaurante.projeto_milionario.infrastructure.entity.Pedido;
import com.restaurante.projeto_milionario.infrastructure.entity.Produto;
import com.restaurante.projeto_milionario.infrastructure.repository.MesaRepository;
import com.restaurante.projeto_milionario.infrastructure.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RelatorioService {
    private final PedidoRepository pedidoRepository;
    private final MesaRepository mesaRepository;

    public RelatorioDTO gerarRelatorioDoDia() {
        LocalDateTime inicio = LocalDateTime.now().minusHours(24);
        List<Pedido> pedidosDoDia = pedidoRepository.buscarPedidosDesde(inicio);

        Integer totalPedidos = pedidosDoDia.size();

        BigDecimal faturamento = pedidosDoDia.stream()
                .flatMap(p -> p.getItens().stream())
                .map(item -> item.getProduto().getPrecoProduto()
                        .multiply(BigDecimal.valueOf(item.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Long mesasOcupadas = mesaRepository.contarMesasOcupadas();

        Map<Produto, Integer> vendasPorProduto = new HashMap<>();
        for (Pedido pedido : pedidosDoDia) {
            for (ItemPedido item : pedido.getItens()) {
                vendasPorProduto.merge(item.getProduto(), item.getQuantidade(), Integer::sum);
            }
        }

        String produtoMaisVendido = vendasPorProduto.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(entry -> entry.getKey().getNomeProduto())
                .orElse("Nenhum produto vendido");

        return new RelatorioDTO(totalPedidos, faturamento, mesasOcupadas, produtoMaisVendido);
    }

}
