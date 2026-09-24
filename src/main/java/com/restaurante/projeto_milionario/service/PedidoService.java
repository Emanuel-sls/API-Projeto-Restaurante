package com.restaurante.projeto_milionario.service;

import com.restaurante.projeto_milionario.Artifact.Disponibilidade;
import com.restaurante.projeto_milionario.infrastructure.entity.ItemPedido;
import com.restaurante.projeto_milionario.infrastructure.entity.Mesa;
import com.restaurante.projeto_milionario.infrastructure.entity.Pedido;
import com.restaurante.projeto_milionario.infrastructure.repository.MesaRepository;
import com.restaurante.projeto_milionario.infrastructure.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final MesaRepository mesaRepository;



    public Pedido criarPedido(Pedido pedido) {
        if (pedido.getItens() != null) {
            for (ItemPedido item : pedido.getItens()) {
                item.setPedido(pedido);
            }
        }

        Pedido salvo = pedidoRepository.save(pedido);

        Mesa mesa = pedido.getMesa();
        mesa.setDisponivel(Disponibilidade.OCUPADO);
        mesaRepository.save(mesa);

        return salvo;
    }


    public Pedido BuscarPedidoPorId(Integer id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido AdicionarItem(Integer idPedido, ItemPedido novoItem) {
        Pedido pedido = BuscarPedidoPorId(idPedido);
        for (ItemPedido item : pedido.getItens()) {
            if (item.getProduto().getId().equals(novoItem.getProduto().getId())) {
                item.setQuantidade(item.getQuantidade() + novoItem.getQuantidade());
                return pedidoRepository.save(pedido);
            }
        }


        novoItem.setPedido(pedido);
        pedido.getItens().add(novoItem);
        return pedidoRepository.save(pedido);

    }

    public Pedido deletarItem(Integer idPedido, Integer idProduto) {
        Pedido pedido = BuscarPedidoPorId(idPedido);
        pedido.getItens().removeIf(item -> item.getProduto().getId().equals(idProduto));

        return pedidoRepository.save(pedido);

    }



    public void deletarPedido(Integer id) {
        Pedido pedido = BuscarPedidoPorId(id);
        pedidoRepository.delete(pedido);
    }
}



