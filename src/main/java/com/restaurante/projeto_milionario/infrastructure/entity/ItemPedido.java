package com.restaurante.projeto_milionario.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name="itens_pedido")
public class ItemPedido {

    @EmbeddedId
    private ItemPedidoId id = new ItemPedidoId();

    @ManyToOne
    @MapsId("idPedidos")
    @JoinColumn(name = "`idPedidos`")
    @JsonBackReference
    private Pedido pedido;

    @ManyToOne
    @MapsId("idPro")
    @JoinColumn(name = "`idPro`")
    private Produto produto;

    @Column(name = "quantidade")
    private Integer quantidade;

}
