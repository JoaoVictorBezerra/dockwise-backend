package com.api.containers.controller;

import com.api.containers.dtos.MovimentacaoDTO;
import com.api.containers.model.ContainerModel;
import com.api.containers.model.MovimentacaoModel;
import com.api.containers.service.ContainerService;
import com.api.containers.service.MovimentacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
    final MovimentacaoService movimentacaoService;
    final ContainerService containerService;
    public MovimentacaoController(MovimentacaoService movimentacaoService, ContainerService containerService) {
        this.movimentacaoService = movimentacaoService;
        this.containerService = containerService;
    }

    @GetMapping
    public ResponseEntity<List<MovimentacaoModel>> getAllMovimentacoes() {
        return ResponseEntity.status(HttpStatus.OK).body(movimentacaoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> saveMovimentacao(@RequestBody @Valid MovimentacaoDTO movimentacaoDTO) {
        var movimentacaoModel = new MovimentacaoModel();
        BeanUtils.copyProperties(movimentacaoDTO, movimentacaoModel);
        boolean existsContainer = containerService.existsContainer(movimentacaoModel.getContainer());
        if(!existsContainer) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Container não encontrado");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoService.salvarMovimentacao(movimentacaoModel));
    }

}
