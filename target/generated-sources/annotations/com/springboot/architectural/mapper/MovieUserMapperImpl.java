package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.RoleDTO;
import com.springboot.architectural.entity.Role;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-27T01:40:24+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class MovieUserMapperImpl implements MovieUserMapper {

    @Override
    public RoleDTO movieUserToMovieUserDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setRole_id( role.getRole_id() );
        roleDTO.setName( role.getName() );

        return roleDTO;
    }

    @Override
    public Role movieUserDtoToMovieUser(RoleDTO roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setRole_id( roleDto.getRole_id() );
        role.setName( roleDto.getName() );

        return role;
    }
}
