package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.Movie_CollectionDTO;
import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Movie_Collection;
import com.springboot.architectural.entity.Movie_User;
import java.sql.Date;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-13T07:35:54+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class MovieCollectionMapperImpl implements MovieCollectionMapper {

    @Override
    public Movie_CollectionDTO movieCollectionToMovieCollectionDto(Movie_Collection movieCollection) {
        if ( movieCollection == null ) {
            return null;
        }

        Movie_CollectionDTO movie_CollectionDTO = new Movie_CollectionDTO();

        movie_CollectionDTO.setMovieId( movieCollectionMovieMovieId( movieCollection ) );
        movie_CollectionDTO.setUsername( movieCollectionMovieUserUsername( movieCollection ) );
        movie_CollectionDTO.setImageMovie( movieCollectionMovieImage( movieCollection ) );
        movie_CollectionDTO.setMovieName( movieCollectionMovieName( movieCollection ) );
        movie_CollectionDTO.setId( movieCollection.getId() );
        if ( movieCollection.getTime() != null ) {
            movie_CollectionDTO.setTime( new Date( movieCollection.getTime().getTime() ) );
        }

        return movie_CollectionDTO;
    }

    @Override
    public Movie_Collection movieCollectionDtoToMovieCollection(Movie_CollectionDTO movieCollectionDTO) {
        if ( movieCollectionDTO == null ) {
            return null;
        }

        Movie_Collection movie_Collection = new Movie_Collection();

        movie_Collection.setId( movieCollectionDTO.getId() );
        movie_Collection.setTime( movieCollectionDTO.getTime() );

        return movie_Collection;
    }

    private Integer movieCollectionMovieMovieId(Movie_Collection movie_Collection) {
        if ( movie_Collection == null ) {
            return null;
        }
        Movie movie = movie_Collection.getMovie();
        if ( movie == null ) {
            return null;
        }
        Integer movieId = movie.getMovieId();
        if ( movieId == null ) {
            return null;
        }
        return movieId;
    }

    private String movieCollectionMovieUserUsername(Movie_Collection movie_Collection) {
        if ( movie_Collection == null ) {
            return null;
        }
        Movie_User movieUser = movie_Collection.getMovieUser();
        if ( movieUser == null ) {
            return null;
        }
        String username = movieUser.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    private String movieCollectionMovieImage(Movie_Collection movie_Collection) {
        if ( movie_Collection == null ) {
            return null;
        }
        Movie movie = movie_Collection.getMovie();
        if ( movie == null ) {
            return null;
        }
        String image = movie.getImage();
        if ( image == null ) {
            return null;
        }
        return image;
    }

    private String movieCollectionMovieName(Movie_Collection movie_Collection) {
        if ( movie_Collection == null ) {
            return null;
        }
        Movie movie = movie_Collection.getMovie();
        if ( movie == null ) {
            return null;
        }
        String name = movie.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
