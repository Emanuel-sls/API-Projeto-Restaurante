package com.restaurante.projeto_milionario.service;


import com.restaurante.projeto_milionario.infrastructure.entity.Categoria;
import com.restaurante.projeto_milionario.infrastructure.entity.Produto;
import com.restaurante.projeto_milionario.infrastructure.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;


    public Produto  salvarProduto(Produto produto){
        Optional<Produto> existente = produtoRepository.findByNomeProduto(produto.getNomeProduto());

        if(existente.isPresent()){
            throw new RuntimeException("Produto ja  existe");
        }
        System.out.println("Produto salvo com sucesso");
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Integer id) {

        Optional<Produto> existente = produtoRepository.findById(id);

        if (existente.isEmpty()) {
            throw new RuntimeException("Produto não existe");
        }

        produtoRepository.delete(existente.get());
    }

    public Produto atualizarProduto(Integer id,Produto produto){
        Optional<Produto> existente = produtoRepository.findById(id);
        if(existente.isEmpty()){
            throw new RuntimeException("Produto não existe");
        }
        existente.get().setNomeProduto(produto.getNomeProduto());
        existente.get().setDescricaoProduto(produto.getDescricaoProduto());
        existente.get().setPrecoProduto(produto.getPrecoProduto());
        existente.get().setCategoria(produto.getCategoria());
        existente.get().setQuantidadeProduto(produto.getQuantidadeProduto());
        return produtoRepository.save(existente.get());

    }

    public Produto BuscarProduto(Integer id) {
        Optional<Produto> existente = produtoRepository.findById(id);
        if (existente.isEmpty()) {
            throw new RuntimeException("Produto não encontrado");
        }
        return existente.get();
    }

    public List<Produto> ListarProdutos() {
        return produtoRepository.findAll();
    }
}
