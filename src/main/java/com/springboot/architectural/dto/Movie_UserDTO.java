package com.springboot.architectural.dto;

import com.springboot.architectural.entity.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movie_UserDTO {
    private String username;
    private String password;
    private String name;
    private String email;
    private String avatar;
    private Integer money;
    private Integer roleId;
    private RoleDTO role;
}
