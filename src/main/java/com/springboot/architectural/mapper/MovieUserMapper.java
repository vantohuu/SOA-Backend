package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.RoleDTO;
import com.springboot.architectural.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieUserMapper {
    MovieUserMapper INSTANCE = Mappers.getMapper(MovieUserMapper.class );
    RoleDTO movieUserToMovieUserDto(Role role);
    Role movieUserDtoToMovieUser(RoleDTO roleDto);
}
