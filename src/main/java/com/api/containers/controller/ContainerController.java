package com.api.containers.controller;

import com.api.containers.controller.advice.BusinessException;
import com.api.containers.controller.advice.Response;
import com.api.containers.dtos.ContainerDTO;
import com.api.containers.model.ContainerModel;
import com.api.containers.service.ContainerService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/containers")
public class ContainerController {
    final ContainerService containerService;
    public ContainerController(ContainerService containerService) {
        this.containerService = containerService;
    }

    @PostMapping
    public ResponseEntity<Object> saveContainer(@RequestBody @Valid ContainerDTO containerDTO) {
        try {
            var containerModel = new ContainerModel();
            BeanUtils.copyProperties(containerDTO, containerModel);
            containerService.save(containerModel);
            Response responseCreated = new Response("Container registrado!", HttpStatus.CREATED);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseCreated);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<ContainerModel>> getAllContainers() {
        return ResponseEntity.status(HttpStatus.OK).body(containerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getContainerById(@PathVariable(value = "id") UUID id) {
        try {
            Optional<ContainerModel> containerModelOptional = containerService.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(containerModelOptional.get());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteContainerById(@PathVariable(value = "id") UUID id) {
        try {
            containerService.deleteById(id);
            Response responseDeleted = new Response("Container was deleted", HttpStatus.OK);
            return ResponseEntity.status(HttpStatus.OK).body(responseDeleted);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateContainer(@PathVariable(value = "id") UUID id, @RequestBody @Valid ContainerDTO containerDTO) {
        try {
            Optional<ContainerModel> containerModelOptional = containerService.findById(id);
            var containerModel = new ContainerModel();
            BeanUtils.copyProperties(containerDTO, containerModel);
            containerModel.setId(containerModelOptional.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body(containerService.save(containerModel));
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
