package com.restaurante.projeto_milionario.infrastructure.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;


@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ItemPedidoId implements Serializable {

    private Integer idPedidos;
    private Integer idPro;


}
