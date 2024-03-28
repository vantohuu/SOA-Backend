package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.Movie_UserDTO;
import com.springboot.architectural.entity.Movie_User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-28T15:12:45+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class MovieUserMapperImpl implements MovieUserMapper {

    @Override
    public Movie_UserDTO movieUserToMovieUserDto(Movie_User movieUser) {
        if ( movieUser == null ) {
            return null;
        }

        Movie_UserDTO movie_UserDTO = new Movie_UserDTO();

        movie_UserDTO.setUsername( movieUser.getUsername() );
        movie_UserDTO.setPassword( movieUser.getPassword() );
        movie_UserDTO.setName( movieUser.getName() );
        movie_UserDTO.setEmail( movieUser.getEmail() );
        movie_UserDTO.setAvatar( movieUser.getAvatar() );
        movie_UserDTO.setMoney( movieUser.getMoney() );
        movie_UserDTO.setRole( movieUser.getRole() );

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
        movie_User.setRole( movieUserDTO.getRole() );

        return movie_User;
    }
}
