package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.Movie_BuyDTO;
import com.springboot.architectural.dto.Movie_CollectionDTO;
import com.springboot.architectural.entity.Movie_Buy;
import com.springboot.architectural.entity.Movie_Collection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieBuyMapper {
    MovieBuyMapper INSTANCE = Mappers.getMapper(MovieBuyMapper.class );
    @Mapping(target = "movieId", source = "movieBuy.movie.movieId")
    @Mapping(target = "username", source = "movieBuy.movieUser.username")
    @Mapping(target = "imageMovie", source = "movieBuy.movie.image")
    @Mapping(target = "movieName", source = "movieBuy.movie.name")
    Movie_BuyDTO movieBuyToMovieBuyDto(Movie_Buy movieBuy);
    Movie_Buy movieBuyDtoToMovieBuy(Movie_BuyDTO movieBuyDTO);
}
