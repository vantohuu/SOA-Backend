package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.RoleDTO;
import com.springboot.architectural.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class );
    RoleDTO roleToRoleDto(Role role);
    Role roleDtoToRole(RoleDTO roleDto);
}
