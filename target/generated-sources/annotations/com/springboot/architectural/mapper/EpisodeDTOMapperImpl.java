package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.EpisodeDTO;
import com.springboot.architectural.entity.Episode;
import com.springboot.architectural.entity.Movie;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-28T20:27:22+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class EpisodeDTOMapperImpl implements EpisodeDTOMapper {

    @Override
    public EpisodeDTO episodeToEpisodeDto(Episode episode) {
        if ( episode == null ) {
            return null;
        }

        EpisodeDTO episodeDTO = new EpisodeDTO();

        episodeDTO.setMovie_id( episodeMovieMovie_id( episode ) );
        episodeDTO.setEpisode_id( episode.getEpisode_id() );
        episodeDTO.setName( episode.getName() );
        episodeDTO.setEpisode( episode.getEpisode() );
        episodeDTO.setSeason( episode.getSeason() );
        episodeDTO.setLink( episode.getLink() );
        episodeDTO.setDay_submit( episode.getDay_submit() );

        return episodeDTO;
    }

    @Override
    public Episode episodeDtoToEpisode(EpisodeDTO episodeDTO) {
        if ( episodeDTO == null ) {
            return null;
        }

        Episode episode = new Episode();

        episode.setEpisode_id( episodeDTO.getEpisode_id() );
        episode.setName( episodeDTO.getName() );
        episode.setEpisode( episodeDTO.getEpisode() );
        episode.setSeason( episodeDTO.getSeason() );
        episode.setLink( episodeDTO.getLink() );
        episode.setDay_submit( episodeDTO.getDay_submit() );

        return episode;
    }

    private Integer episodeMovieMovie_id(Episode episode) {
        if ( episode == null ) {
            return null;
        }
        Movie movie = episode.getMovie();
        if ( movie == null ) {
            return null;
        }
        Integer movie_id = movie.getMovie_id();
        if ( movie_id == null ) {
            return null;
        }
        return movie_id;
    }
}
