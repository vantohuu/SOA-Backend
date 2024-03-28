package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.MovieDTO;
import com.springboot.architectural.entity.Episode;
import com.springboot.architectural.dto.EpisodeDTO;
import com.springboot.architectural.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EpisodeDTOMapper {
    EpisodeDTOMapper INSTANCE = Mappers.getMapper(EpisodeDTOMapper.class );
    @Mapping(target = "movie_id", source = "episode.movie.movie_id")
    EpisodeDTO episodeToEpisodeDto(Episode episode);
    Episode episodeDtoToEpisode(EpisodeDTO episodeDTO);
}
