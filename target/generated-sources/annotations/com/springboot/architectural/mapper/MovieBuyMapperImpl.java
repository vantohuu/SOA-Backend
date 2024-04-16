package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.Movie_BuyDTO;
import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Movie_Buy;
import com.springboot.architectural.entity.Movie_User;
import java.sql.Date;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T14:06:58+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class MovieBuyMapperImpl implements MovieBuyMapper {

    @Override
    public Movie_BuyDTO movieBuyToMovieBuyDto(Movie_Buy movieBuy) {
        if ( movieBuy == null ) {
            return null;
        }

        Movie_BuyDTO movie_BuyDTO = new Movie_BuyDTO();

        movie_BuyDTO.setMovieId( movieBuyMovieMovieId( movieBuy ) );
        movie_BuyDTO.setUsername( movieBuyMovieUserUsername( movieBuy ) );
        movie_BuyDTO.setImageMovie( movieBuyMovieImage( movieBuy ) );
        movie_BuyDTO.setMovieName( movieBuyMovieName( movieBuy ) );
        movie_BuyDTO.setId( movieBuy.getId() );
        if ( movieBuy.getTime() != null ) {
            movie_BuyDTO.setTime( new Date( movieBuy.getTime().getTime() ) );
        }

        return movie_BuyDTO;
    }

    @Override
    public Movie_Buy movieBuyDtoToMovieBuy(Movie_BuyDTO movieBuyDTO) {
        if ( movieBuyDTO == null ) {
            return null;
        }

        Movie_Buy movie_Buy = new Movie_Buy();

        movie_Buy.setId( movieBuyDTO.getId() );
        movie_Buy.setTime( movieBuyDTO.getTime() );

        return movie_Buy;
    }

    private Integer movieBuyMovieMovieId(Movie_Buy movie_Buy) {
        if ( movie_Buy == null ) {
            return null;
        }
        Movie movie = movie_Buy.getMovie();
        if ( movie == null ) {
            return null;
        }
        Integer movieId = movie.getMovieId();
        if ( movieId == null ) {
            return null;
        }
        return movieId;
    }

    private String movieBuyMovieUserUsername(Movie_Buy movie_Buy) {
        if ( movie_Buy == null ) {
            return null;
        }
        Movie_User movieUser = movie_Buy.getMovieUser();
        if ( movieUser == null ) {
            return null;
        }
        String username = movieUser.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    private String movieBuyMovieImage(Movie_Buy movie_Buy) {
        if ( movie_Buy == null ) {
            return null;
        }
        Movie movie = movie_Buy.getMovie();
        if ( movie == null ) {
            return null;
        }
        String image = movie.getImage();
        if ( image == null ) {
            return null;
        }
        return image;
    }

    private String movieBuyMovieName(Movie_Buy movie_Buy) {
        if ( movie_Buy == null ) {
            return null;
        }
        Movie movie = movie_Buy.getMovie();
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
