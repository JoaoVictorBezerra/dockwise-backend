package com.api.containers.repositories;
import com.api.containers.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    Optional<UserModel> findByUsernameAndPassword(String username, String password);
    boolean existsByUsername(String username);
}
