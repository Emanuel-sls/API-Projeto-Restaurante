package com.restaurante.projeto_milionario.controller;

import com.restaurante.projeto_milionario.infrastructure.entity.ItemPedido;
import com.restaurante.projeto_milionario.infrastructure.entity.Pedido;
import com.restaurante.projeto_milionario.infrastructure.repository.PedidoRepository;
import com.restaurante.projeto_milionario.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> salvarPedido(@RequestBody Pedido pedido) {
        return ResponseEntity.ok().body(pedidoService.criarPedido(pedido));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPedidoId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(pedidoService.BuscarPedidoPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> buscarPedidos() {
        return ResponseEntity.ok().body(pedidoService.listarPedidos());
    }

    @PostMapping("/{idPedido}/itens")
    public ResponseEntity<Pedido> adicionarItensPedido(@PathVariable Integer idPedido, @RequestBody ItemPedido item) {
        return ResponseEntity.ok().body(pedidoService.AdicionarItem(idPedido, item));
    }

    @DeleteMapping("/{idPedido}/itens/{idProduto}")
    public ResponseEntity<Pedido> removerItensPedido(@PathVariable Integer idPedido, @PathVariable Integer idProduto){
        return ResponseEntity.ok().body(pedidoService.deletarItem(idPedido, idProduto));
    }
    @DeleteMapping("/deletar/{idPedido}")
    public ResponseEntity<Void> removerPedido(@PathVariable Integer idPedido){
        pedidoService.deletarPedido(idPedido);
        return ResponseEntity.noContent().build();
    }

}
