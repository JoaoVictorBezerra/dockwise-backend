package com.api.containers.repositories;

import com.api.containers.model.MovimentacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MovimentacaoRepository extends JpaRepository<MovimentacaoModel, UUID> {
    boolean existsByContainer(String container);
}
