package com.api.containers.service;

import com.api.containers.controller.advice.BusinessException;
import com.api.containers.model.ContainerModel;
import com.api.containers.repositories.ContainerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContainerService {
    final ContainerRepository containerRepository;

    public ContainerService(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    public ContainerModel save(ContainerModel containerModel) throws Exception {
        if (existsContainer(containerModel.getContainer())) {
            throw new Exception("Container already registered.");
        }
        return containerRepository.save(containerModel);
    }

    public boolean existsContainer(String container) {
        return containerRepository.existsByContainer(container);
    }

    public List<ContainerModel> findAll() {
        return containerRepository.findAll();
    }

    public Optional<ContainerModel> findById(UUID id) {
        return containerRepository.findById(id);
    }

    public void deleteById(UUID id) {
        Optional<ContainerModel> optionalContainerModel = findById(id);
        if(!optionalContainerModel.isPresent()) {
            throw new BusinessException("Container not found");
        }
        containerRepository.delete(optionalContainerModel.get());
    }
}
