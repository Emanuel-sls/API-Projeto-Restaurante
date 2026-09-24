package com.restaurante.projeto_milionario.infrastructure.entity;


import com.restaurante.projeto_milionario.Artifact.Disponibilidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mesa")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_mesa")
    private Integer idMesa;

    @Column(name="mesa_disponivel")
    @Enumerated(EnumType.STRING)
    private Disponibilidade disponivel;

    @Column(name = "numero_mesa")
    private Integer numeroMesa;

    @Column(name="capacidade")
    private Integer capacidade;


}
