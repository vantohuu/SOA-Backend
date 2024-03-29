package com.springboot.architectural.mapper;

import com.springboot.architectural.entity.Episode;
import com.springboot.architectural.dto.EpisodeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EpisodeMapper {
    EpisodeMapper INSTANCE = Mappers.getMapper(EpisodeMapper.class );
    @Mapping(target = "movieId", source = "episode.movie.movieId")
    EpisodeDTO episodeToEpisodeDto(Episode episode);
    Episode episodeDtoToEpisode(EpisodeDTO episodeDTO);
}
