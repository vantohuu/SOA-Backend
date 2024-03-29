package com.springboot.architectural.service.imp;

import com.springboot.architectural.dto.RoleDTO;
import com.springboot.architectural.entity.Role;
import com.springboot.architectural.mapper.RoleMapper;
import com.springboot.architectural.repository.RoleRepository;
import com.springboot.architectural.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleDTO getById(int id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.map(RoleMapper.INSTANCE::roleToRoleDto).orElse(null);
    }

    public List<RoleDTO> getAll() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(RoleMapper.INSTANCE::roleToRoleDto).collect(Collectors.toList());
    }

    @Override
    public RoleDTO add(RoleDTO role) {
        Role roleEntity = RoleMapper.INSTANCE.roleDtoToRole(role);
        System.out.println(roleEntity);
        if (role.getName() == null ) return  null;
        return  RoleMapper.INSTANCE.roleToRoleDto(roleRepository.save(roleEntity));
    }

    @Override
    public RoleDTO update(RoleDTO role) {
        Optional<Role> checkRR = roleRepository.findById(role.getRoleId());
        if (checkRR.isEmpty()) return null;
        Role roomRegisEntity = RoleMapper.INSTANCE.roleDtoToRole(role);
        return  RoleMapper.INSTANCE.roleToRoleDto(roleRepository.save(roomRegisEntity));
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Role> r = roleRepository.findById(id);
        if (r.isPresent())
        {
            roleRepository.delete(r.get());
            return true;
        }
        return false;
    }
}
