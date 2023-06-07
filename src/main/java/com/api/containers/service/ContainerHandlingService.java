package com.api.containers.service;

import com.api.containers.model.ContainerHandlingModel;
import com.api.containers.repositories.ContainerHandlingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContainerHandlingService {

    final ContainerHandlingRepository containerHandlingRepository;
    final ContainerService containerService;
    public ContainerHandlingService(ContainerHandlingRepository containerHandlingRepository, ContainerService containerService) {
        this.containerHandlingRepository = containerHandlingRepository;
        this.containerService = containerService;
    }
    public void saveContainerHandling(ContainerHandlingModel containerHandlingModel) throws Exception {
        boolean existsContainer = containerService.existsContainer(containerHandlingModel.getContainer());
        if(!existsContainer) {
            throw new Exception("Container not found");
        }
        containerHandlingRepository.save(containerHandlingModel);
    }

    public List<ContainerHandlingModel> findAll() {
        return containerHandlingRepository.findAll();
    }
}
