package com.api.containers.service;

import com.api.containers.model.UserModel;
import com.api.containers.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserModel save(UserModel userModel) throws Exception {
        if(existsUser(userModel.getUsername())) {
            throw new Exception("Usuário já registrado.");
        }
        return userRepository.save(userModel);
    }
    public Optional<UserModel> existsByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
    public boolean existsUser(String username) {
        return userRepository.existsByUsername(username);
    }
}
