package com.restaurante.projeto_milionario.controller;


import com.restaurante.projeto_milionario.infrastructure.entity.Categoria;
import com.restaurante.projeto_milionario.infrastructure.entity.Produto;
import com.restaurante.projeto_milionario.infrastructure.repository.ProdutoRepository;
import com.restaurante.projeto_milionario.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto){
        return ResponseEntity.ok().body(produtoService.salvarProduto(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Integer id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProduto(@PathVariable Integer id){
        return ResponseEntity.ok().body(produtoService.BuscarProduto(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto( @RequestBody Produto produto,@PathVariable Integer id) {

        return ResponseEntity.ok(
                produtoService.atualizarProduto(id,produto)
        );
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Produto>> listarProdutos() {
       return ResponseEntity.ok(produtoService.ListarProdutos());
    }


}
