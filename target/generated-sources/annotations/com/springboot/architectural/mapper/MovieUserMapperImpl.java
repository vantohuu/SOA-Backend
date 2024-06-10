package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.Movie_UserDTO;
import com.springboot.architectural.dto.RoleDTO;
import com.springboot.architectural.entity.Movie_User;
import com.springboot.architectural.entity.Role;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-10T19:49:26+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class MovieUserMapperImpl implements MovieUserMapper {

    @Override
    public Movie_UserDTO movieUserToMovieUserDto(Movie_User movieUser) {
        if ( movieUser == null ) {
            return null;
        }

        Movie_UserDTO movie_UserDTO = new Movie_UserDTO();

        movie_UserDTO.setRoleId( movieUserRoleRoleId( movieUser ) );
        movie_UserDTO.setUsername( movieUser.getUsername() );
        movie_UserDTO.setPassword( movieUser.getPassword() );
        movie_UserDTO.setName( movieUser.getName() );
        movie_UserDTO.setEmail( movieUser.getEmail() );
        movie_UserDTO.setAvatar( movieUser.getAvatar() );
        movie_UserDTO.setMoney( movieUser.getMoney() );
        movie_UserDTO.setRole( roleToRoleDTO( movieUser.getRole() ) );

        return movie_UserDTO;
    }

    @Override
    public Movie_User movieUserDtoToMovieUser(Movie_UserDTO movieUserDTO) {
        if ( movieUserDTO == null ) {
            return null;
        }

        Movie_User movie_User = new Movie_User();

        movie_User.setUsername( movieUserDTO.getUsername() );
        movie_User.setPassword( movieUserDTO.getPassword() );
        movie_User.setName( movieUserDTO.getName() );
        movie_User.setEmail( movieUserDTO.getEmail() );
        movie_User.setAvatar( movieUserDTO.getAvatar() );
        movie_User.setMoney( movieUserDTO.getMoney() );
        movie_User.setRole( roleDTOToRole( movieUserDTO.getRole() ) );

        return movie_User;
    }

    private Integer movieUserRoleRoleId(Movie_User movie_User) {
        if ( movie_User == null ) {
            return null;
        }
        Role role = movie_User.getRole();
        if ( role == null ) {
            return null;
        }
        Integer roleId = role.getRoleId();
        if ( roleId == null ) {
            return null;
        }
        return roleId;
    }

    protected RoleDTO roleToRoleDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setRoleId( role.getRoleId() );
        roleDTO.setName( role.getName() );

        return roleDTO;
    }

    protected Role roleDTOToRole(RoleDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        Role role = new Role();

        role.setRoleId( roleDTO.getRoleId() );
        role.setName( roleDTO.getName() );

        return role;
    }
}
