package com.api.containers.controller;

import com.api.containers.controller.advice.BusinessException;
import com.api.containers.controller.advice.Response;
import com.api.containers.dtos.ContainerHandlingDTO;
import com.api.containers.model.ContainerHandlingModel;
import com.api.containers.service.ContainerService;
import com.api.containers.service.ContainerHandlingService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/containerhandling")
public class ContainerHandlingController {
    final ContainerHandlingService containerHandlingService;
    public ContainerHandlingController(ContainerHandlingService containerHandlingService, ContainerService containerService) {
        this.containerHandlingService = containerHandlingService;
    }

    @GetMapping
    public ResponseEntity<List<ContainerHandlingModel>> getAllContainerHandling() {
        return ResponseEntity.status(HttpStatus.OK).body(containerHandlingService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> saveContainerHandling(@RequestBody @Valid ContainerHandlingDTO ContainerHandlingDTO) {
        try
        {
            ContainerHandlingModel containerHandlingModel = new ContainerHandlingModel();
            BeanUtils.copyProperties(ContainerHandlingDTO, containerHandlingModel);
            Response responseOk = new Response("Container Handling has been created",HttpStatus.OK);
            containerHandlingService.saveContainerHandling(containerHandlingModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseOk);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
