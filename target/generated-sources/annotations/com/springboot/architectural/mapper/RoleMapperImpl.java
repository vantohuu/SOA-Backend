package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.RoleDTO;
import com.springboot.architectural.entity.Role;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-10T19:49:26+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDTO roleToRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setRoleId( role.getRoleId() );
        roleDTO.setName( role.getName() );

        return roleDTO;
    }

    @Override
    public Role roleDtoToRole(RoleDTO roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setRoleId( roleDto.getRoleId() );
        role.setName( roleDto.getName() );

        return role;
    }
}
