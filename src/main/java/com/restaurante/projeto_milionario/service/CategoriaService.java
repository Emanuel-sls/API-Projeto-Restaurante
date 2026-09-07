package com.restaurante.projeto_milionario.service;

import com.restaurante.projeto_milionario.infrastructure.entity.Categoria;
import com.restaurante.projeto_milionario.infrastructure.repository.CategoriaRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor

public class CategoriaService {

    private  final CategoriaRepository categoriaRepository;

    public  Categoria SalvarCategoria(Categoria categoria){

        Optional<Categoria> existente = categoriaRepository.findByNomeCategoria(categoria.getNomeCategoria());


        if(existente.isPresent()){

             throw new RuntimeException("Categoria Ja existe");
        }
        System.out.println("Categoria Salva com sucesso");
        return categoriaRepository.save(categoria);

    }

    public void DeletarCategoria(Long id){
        Optional<Categoria> existente = categoriaRepository.findById(id);

        if(existente.isEmpty()){
            throw new RuntimeException("Categoria Não Encontrada");


        }
        categoriaRepository.delete(existente.get());
    }

    public Categoria AlterarCategoria(Long id, Categoria categoria) {

        Categoria categoriaExistente = BuscarCategoria(id);

        categoriaExistente.setNomeCategoria(categoria.getNomeCategoria());
        categoriaExistente.setDescCategoria(categoria.getDescCategoria());

        return categoriaRepository.save(categoriaExistente);
    }
    public Categoria BuscarCategoria(Long id) {
        Optional<Categoria> existente = categoriaRepository.findById(id);
        if (existente.isEmpty()) {
            throw new RuntimeException("Categoria não encontrada");
        }

        return existente.get();
    }
    public List<Categoria> ListarCategorias() {
        return categoriaRepository.findAll();
    }
}
