package com.restaurante.projeto_milionario.infrastructure.entity;


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
    private int idMesa;

    @Column(name="mesa_disponivel")
    private boolean mesaDisponivel;

    @Column(name = "numero_mesa")
    private int numeroMesa;


}
