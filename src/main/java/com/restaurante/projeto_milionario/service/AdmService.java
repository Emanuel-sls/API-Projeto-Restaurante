package com.restaurante.projeto_milionario.service;

import com.restaurante.projeto_milionario.infrastructure.entity.Administrador;
import com.restaurante.projeto_milionario.infrastructure.repository.AdmiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdmService  {
    private final AdmiRepository admiRepository;

    public Administrador cadastrarAdmi(Administrador admi){
        Optional<Administrador> existente =  admiRepository.findByNomeAdm(admi.getNomeAdm());

        if(existente.isPresent()){
            throw new RuntimeException("Esse administrador ja existe");
        }
        System.out.println("Cadastrando Admi");
        return admiRepository.save(admi);
    }


    public Administrador Validaradm( Administrador admi){
        Optional<Administrador> Userexistente =  admiRepository.findByNomeAdm(admi.getNomeAdm());
        Optional<Administrador> Senharexistente =  admiRepository.findByNomeAdm(admi.getSenhaHash());

        if(Userexistente.isPresent() && Senharexistente.isPresent()){
            System.out.println("logando");
        }
        throw  new RuntimeException("Erro ao cadastrar Admi");

    }



}
