package com.restaurante.projeto_milionario.controller;

import com.restaurante.projeto_milionario.DTO.RelatorioDTO;
import com.restaurante.projeto_milionario.infrastructure.entity.Administrador;
import com.restaurante.projeto_milionario.infrastructure.repository.AdmiRepository;
import com.restaurante.projeto_milionario.service.AdmService;
import com.restaurante.projeto_milionario.service.MesaService;
import com.restaurante.projeto_milionario.service.RelatorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adm")
@RequiredArgsConstructor
public class AdmController {


    private final AdmService admService;
    private final RelatorioService relatorioService;
    private final MesaService mesaService;

        @GetMapping("/dia")
        public ResponseEntity<RelatorioDTO> relatorioDoDia() {
            return ResponseEntity.ok(relatorioService.gerarRelatorioDoDia());
        }{
    }
}






