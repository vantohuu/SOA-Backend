package com.springboot.architectural.service;

import com.springboot.architectural.dto.RoleDTO;
import com.springboot.architectural.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    RoleDTO getById(int id);
    List<RoleDTO> getAll();
    RoleDTO add(RoleDTO roleDTO);
    RoleDTO update(RoleDTO roleDTO);
    boolean delete(Integer id);
}
