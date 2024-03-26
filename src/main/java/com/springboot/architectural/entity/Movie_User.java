package com.springboot.architectural.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "Movie_User")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movie_User {
    @Id
    private String username;
    private String password;
    private String name;
    private String email;
    private String avatar;
    private Integer money;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
