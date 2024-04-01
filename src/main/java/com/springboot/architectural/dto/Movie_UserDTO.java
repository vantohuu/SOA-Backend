package com.springboot.architectural.dto;

import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Movie_Collection;
import com.springboot.architectural.entity.Role;
import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Set;

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
