package com.api.containers.dtos;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class MovimentacaoDTO {

    @NotBlank
    @Size(max = 11)
    private String container;
    @NotBlank
    private String tipoMovimentacao;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioFinal;
}
