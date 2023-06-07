package com.api.containers.controller;

import com.api.containers.controller.advice.BusinessException;
import com.api.containers.controller.advice.Response;
import com.api.containers.dtos.User.ResponseUserDTO;
import com.api.containers.dtos.User.UserDTO;
import com.api.containers.model.UserModel;
import com.api.containers.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDTO userDTO) {
        try {
            var userModel = new UserModel();
            BeanUtils.copyProperties(userDTO, userModel);
            userService.save(userModel);
            Response responseCreated = new Response("User has been created.", HttpStatus.CREATED);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseCreated);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }
    @GetMapping("/{username}-{password}")
    public ResponseEntity<Object> getUser(@PathVariable(value = "username") String username, @PathVariable(value = "password") String password) {
        try {
            Optional<UserModel> userModelOptional = userService.existsByUsernameAndPassword(username, password);
            UserModel user = userModelOptional.get();
            ResponseUserDTO responseUserDTO = new ResponseUserDTO(user.getId(), user.getUsername(), user.getName(), user.getUserType());
            return ResponseEntity.status(HttpStatus.OK).body(responseUserDTO);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
