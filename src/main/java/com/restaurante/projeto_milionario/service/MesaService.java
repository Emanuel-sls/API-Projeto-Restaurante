package com.restaurante.projeto_milionario.service;

import com.restaurante.projeto_milionario.Artifact.Disponibilidade;
import com.restaurante.projeto_milionario.infrastructure.entity.Categoria;
import com.restaurante.projeto_milionario.infrastructure.entity.Mesa;
import com.restaurante.projeto_milionario.infrastructure.repository.MesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MesaService {
    private final MesaRepository mesaRepository;

    public Mesa criarMesa(Integer numeroMesa, Integer capacidade) {
        if (mesaRepository.findByNumeroMesa(numeroMesa).isPresent()) {
            throw new RuntimeException("A mesa com o numero indicado ja existe/ foi cadastrado");
        }

        Mesa mesa = new Mesa();
        mesa.setNumeroMesa(numeroMesa);
        mesa.setCapacidade(capacidade);
        mesa.setDisponivel(Disponibilidade.DISPONIVEL);
        return mesaRepository.save(mesa);
    }

    public Mesa mudarDisponivel(Integer id, Disponibilidade disponibilidade) {

        Mesa mesa = mesaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa não encontrada"));


        if (mesa.getDisponivel() == disponibilidade) {
            throw new RuntimeException("Essa Mesa Ja esta "+disponibilidade);
        }
        mesa.setDisponivel(disponibilidade);
        return mesaRepository.save(mesa);
    }

    public Mesa chamarGarcom(Integer id) {
        Mesa mesa = mesaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa não encontrada"));

        if (mesa.getDisponivel() == Disponibilidade.DISPONIVEL) {
            throw new RuntimeException("só é possivel  chamar o garçom em uma mesa ocupada");
        }

        mesa.setDisponivel(Disponibilidade.AGUARDANDO_GARCOM);
        return mesaRepository.save(mesa);
    }

    public List<Mesa> listarMesas() {
        return mesaRepository.findAll();
    }

    public void deletarMesa(Integer id) {
        Mesa mesa = mesaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa não encontrada"));
        mesaRepository.delete(mesa);
    }

    public Mesa editarMesa(Integer id, Integer numeroMesa, Integer capacidade) {
        Mesa mesa = mesaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa não encontrada"));

        mesa.setNumeroMesa(numeroMesa);
        mesa.setCapacidade(capacidade);
        return mesaRepository.save(mesa);
    }
    public Mesa buscarMesa(Integer id) {
        return mesaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa não encontrada"));
    }


    }






