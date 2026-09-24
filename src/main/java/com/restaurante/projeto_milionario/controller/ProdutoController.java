package com.restaurante.projeto_milionario.controller;


import com.restaurante.projeto_milionario.infrastructure.entity.Categoria;
import com.restaurante.projeto_milionario.infrastructure.entity.Produto;
import com.restaurante.projeto_milionario.infrastructure.repository.ProdutoRepository;
import com.restaurante.projeto_milionario.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;
    private final ProdutoRepository produtoRepository;

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
    public Produto atualizarProduto(Integer id, Produto produto) {
        Optional<Produto> existenteOpt = produtoRepository.findById(id);
        if (existenteOpt.isEmpty()) {
            throw new RuntimeException("Produto não existe");
        }
        Produto existente = existenteOpt.get();

        if (produto.getNomeProduto() != null && !produto.getNomeProduto().isBlank()) {
            existente.setNomeProduto(produto.getNomeProduto());
        }

        if (produto.getDescricaoProduto() != null && !produto.getDescricaoProduto().isBlank()) {
            existente.setDescricaoProduto(produto.getDescricaoProduto());
        }

        if (produto.getPrecoProduto() != null) {
            existente.setPrecoProduto(produto.getPrecoProduto());
        }

        if (produto.getCategoria() != null) {
            existente.setCategoria(produto.getCategoria());
        }

        if (produto.getQuantidadeProduto() != null) {
            existente.setQuantidadeProduto(produto.getQuantidadeProduto());
        }

        // imagem: null = "não mexeu", "" (string vazia) = "remover", url = "trocar/adicionar"
        if (produto.getImagemUrlProduto() != null) {
            if (produto.getImagemUrlProduto().isBlank()) {
                existente.setImagemUrlProduto(null); // remove a imagem explicitamente
            } else {
                existente.setImagemUrlProduto(produto.getImagemUrlProduto());
            }
        }

        return produtoRepository.save(existente);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Produto>> listarProdutos() {
       return ResponseEntity.ok(produtoService.ListarProdutos());
    }


}
