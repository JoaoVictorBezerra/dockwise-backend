package com.api.containers.repositories;

import com.api.containers.model.ContainerHandlingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ContainerHandlingRepository extends JpaRepository<ContainerHandlingModel, UUID> {
    boolean existsByContainer(String container);
}
