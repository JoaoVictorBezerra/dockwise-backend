package com.api.containers.dtos.User;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ResponseUserDTO {
    private UUID id;
    private String username;
    private String name;
    private String userType;

    public ResponseUserDTO(UUID id, String username, String name, String userType){
        this.id = id;
        this.username = username;
        this.name = name;
        this.userType = userType;
    }
}
