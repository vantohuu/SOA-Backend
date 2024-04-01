package com.springboot.architectural.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Movie_User")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
