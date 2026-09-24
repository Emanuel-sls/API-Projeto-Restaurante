package com.restaurante.projeto_milionario.controller;

import com.restaurante.projeto_milionario.Artifact.Disponibilidade;
import com.restaurante.projeto_milionario.infrastructure.entity.Mesa;
import com.restaurante.projeto_milionario.service.MesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
@RequiredArgsConstructor
public class MesaController {
    private final MesaService mesaService;



    @PostMapping
    public ResponseEntity<Mesa> cadastrarMesa(@RequestParam Integer numeroMesa, @RequestParam Integer capacidade) {
        return ResponseEntity.ok().body(mesaService.criarMesa(numeroMesa, capacidade));
    }

    @PutMapping("/{id}/disponibilidade")
    public ResponseEntity<Mesa> mudarStatus(@PathVariable Integer id, @RequestParam Disponibilidade    disponibilidade){
        return ResponseEntity.ok().body(mesaService.mudarDisponivel(id,disponibilidade));
    }

    @PutMapping("/{id}/chamar-garcom")
    public ResponseEntity<Mesa> chamarGarcom(@PathVariable Integer id) {
        return ResponseEntity.ok().body(mesaService.chamarGarcom(id));
    }

    @GetMapping("/listar-mesas")
    public ResponseEntity<List<Mesa>> listarMesas() {
        return ResponseEntity.ok(mesaService.listarMesas());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMesa(@PathVariable Integer id) {
        mesaService.deletarMesa(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mesa> editarMesa(
            @PathVariable Integer id,
            @RequestParam Integer numeroMesa,
            @RequestParam Integer capacidade) {
        return ResponseEntity.ok(mesaService.editarMesa(id, numeroMesa, capacidade));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Mesa> buscarMesa(@PathVariable Integer id) {
        return ResponseEntity.ok(mesaService.buscarMesa(id));
    }


}



