package com.api.containers.dtos;

import com.api.containers.model.ContainerModel;
import com.api.containers.repositories.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContainerDTO {
    @NotBlank
    @Size(max = 50)
    private String client;
    @NotBlank
    @Size(max = 11)
    private String container;
    @NotNull
    public int size;
    @NotBlank
    @Size(max = 5)
    public String status;
    @NotBlank
    @Size(max = 10)
    public String category;
}
