package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.Movie_CollectionDTO;
import com.springboot.architectural.dto.Movie_PersonDTO;
import com.springboot.architectural.entity.Movie_Collection;
import com.springboot.architectural.entity.Movie_Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieCollectionMapper {
    MovieCollectionMapper INSTANCE = Mappers.getMapper(MovieCollectionMapper.class );
    Movie_CollectionDTO movieCollectionToMovieCollectionDto(Movie_Collection movieCollection);
    Movie_Collection movieCollectionDtoToMovieCollection(Movie_CollectionDTO movieCollectionDTO);
}
