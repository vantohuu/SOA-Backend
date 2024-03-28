package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.MovieDTO;
import com.springboot.architectural.entity.Country;
import com.springboot.architectural.entity.Movie;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-28T15:12:45+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class MovieMapperImpl implements MovieMapper {

    @Override
    public MovieDTO movieToMovieDto(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        MovieDTO movieDTO = new MovieDTO();

        movieDTO.setCountry_id( movieCountryCountry_id( movie ) );
        movieDTO.setMovie_id( movie.getMovie_id() );
        movieDTO.setName( movie.getName() );
        movieDTO.setMovie_content( movie.getMovie_content() );
        movieDTO.setEpisodes( movie.getEpisodes() );
        movieDTO.setMovie_schedule( movie.getMovie_schedule() );
        movieDTO.setImage( movie.getImage() );
        movieDTO.setCountry( movie.getCountry() );
        movieDTO.setStar( movie.getStar() );
        movieDTO.setPrice( movie.getPrice() );
        movieDTO.setViews( movie.getViews() );
        movieDTO.setStatus( movie.getStatus() );

        return movieDTO;
    }

    @Override
    public Movie movieDtoToMovie(MovieDTO movieDTO) {
        if ( movieDTO == null ) {
            return null;
        }

        Movie movie = new Movie();

        movie.setMovie_id( movieDTO.getMovie_id() );
        movie.setName( movieDTO.getName() );
        movie.setMovie_content( movieDTO.getMovie_content() );
        movie.setEpisodes( movieDTO.getEpisodes() );
        movie.setMovie_schedule( movieDTO.getMovie_schedule() );
        movie.setImage( movieDTO.getImage() );
        movie.setCountry( movieDTO.getCountry() );
        movie.setStar( movieDTO.getStar() );
        movie.setPrice( movieDTO.getPrice() );
        movie.setViews( movieDTO.getViews() );
        movie.setStatus( movieDTO.getStatus() );

        return movie;
    }

    private Integer movieCountryCountry_id(Movie movie) {
        if ( movie == null ) {
            return null;
        }
        Country country = movie.getCountry();
        if ( country == null ) {
            return null;
        }
        Integer country_id = country.getCountry_id();
        if ( country_id == null ) {
            return null;
        }
        return country_id;
    }
}
