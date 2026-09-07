package com.restaurante.projeto_milionario.infrastructure.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produtos")



public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPro")
    private Integer id;

    @Column(name = "nome")
    private String nomeProduto;

    @Column(name = "quantidade")
    private Integer quantidadeProduto;

    @Column(name = "preco")
    private BigDecimal precoProduto;

    @Column(name = "descricao")
    private String descricaoProduto;

    @JoinColumn(name="id_cate")
    @ManyToOne
    private Categoria categoria;
}
