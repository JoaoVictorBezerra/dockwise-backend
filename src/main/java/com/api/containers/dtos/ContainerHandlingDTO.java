package com.api.containers.dtos;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class ContainerHandlingDTO {

    @NotBlank
    @Size(max = 11)
    private String container;
    @NotBlank
    private String handlingType;
    private LocalDateTime initialTime;
    private LocalDateTime finalTime;
}
