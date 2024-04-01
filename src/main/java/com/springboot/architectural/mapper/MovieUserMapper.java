package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.MovieDTO;
import com.springboot.architectural.dto.Movie_UserDTO;
import com.springboot.architectural.dto.RoleDTO;
import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Movie_User;
import com.springboot.architectural.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieUserMapper {
    MovieUserMapper INSTANCE = Mappers.getMapper(MovieUserMapper.class );
    @Mapping(target = "roleId", source = "movieUser.role.roleId")

    Movie_UserDTO movieUserToMovieUserDto(Movie_User movieUser);
    Movie_User movieUserDtoToMovieUser(Movie_UserDTO movieUserDTO);
}
