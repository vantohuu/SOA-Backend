package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.Movie_CollectionDTO;
import com.springboot.architectural.entity.Movie_Collection;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-29T11:09:22+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class MovieCollectionMapperImpl implements MovieCollectionMapper {

    @Override
    public Movie_CollectionDTO movieCollectionToMovieCollectionDto(Movie_Collection movieCollection) {
        if ( movieCollection == null ) {
            return null;
        }

        Movie_CollectionDTO movie_CollectionDTO = new Movie_CollectionDTO();

        movie_CollectionDTO.setId( movieCollection.getId() );
        movie_CollectionDTO.setMovie( movieCollection.getMovie() );
        movie_CollectionDTO.setMovieUser( movieCollection.getMovieUser() );

        return movie_CollectionDTO;
    }

    @Override
    public Movie_Collection movieCollectionDtoToMovieCollection(Movie_CollectionDTO movieCollectionDTO) {
        if ( movieCollectionDTO == null ) {
            return null;
        }

        Movie_Collection movie_Collection = new Movie_Collection();

        movie_Collection.setId( movieCollectionDTO.getId() );
        movie_Collection.setMovie( movieCollectionDTO.getMovie() );
        movie_Collection.setMovieUser( movieCollectionDTO.getMovieUser() );

        return movie_Collection;
    }
}
