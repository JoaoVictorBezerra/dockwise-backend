package com.api.containers.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "MovimentacaoContainers")
public class MovimentacaoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String container;
    @Column(nullable = false)
    private String tipoMovimentacao;
    @Column(nullable = false)
    private LocalDateTime horarioInicio;
    @Column(nullable = false)
    private LocalDateTime horarioFinal;
}
