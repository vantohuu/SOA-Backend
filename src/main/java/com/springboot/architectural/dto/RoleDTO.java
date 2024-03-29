package com.springboot.architectural.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleDTO {
    private Integer roleId;
    private String name;

}
