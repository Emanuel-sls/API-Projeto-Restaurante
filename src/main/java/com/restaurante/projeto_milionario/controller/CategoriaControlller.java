package com.restaurante.projeto_milionario.controller;


import com.restaurante.projeto_milionario.infrastructure.entity.Categoria;
import com.restaurante.projeto_milionario.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaControlller{

    private  final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria){
        return ResponseEntity.ok().body(categoriaService.SalvarCategoria(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        categoriaService.DeletarCategoria(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarCategoria(@PathVariable Long id){
        return ResponseEntity.ok().body(categoriaService.BuscarCategoria(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(
            @PathVariable Long id,
            @RequestBody Categoria categoria) {

        return ResponseEntity.ok(
                categoriaService.AlterarCategoria(id,categoria)
        );
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Categoria>> listarCategorias() {
        return ResponseEntity.ok(categoriaService.ListarCategorias());
    }


}
