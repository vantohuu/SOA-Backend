package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.EpisodeDTO;
import com.springboot.architectural.entity.Episode;
import com.springboot.architectural.entity.Movie;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-29T01:57:46+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class EpisodeMapperImpl implements EpisodeMapper {

    @Override
    public EpisodeDTO episodeToEpisodeDto(Episode episode) {
        if ( episode == null ) {
            return null;
        }

        EpisodeDTO episodeDTO = new EpisodeDTO();

        episodeDTO.setMovieId( episodeMovieMovieId( episode ) );
        episodeDTO.setEpisodeId( episode.getEpisodeId() );
        episodeDTO.setName( episode.getName() );
        episodeDTO.setEpisode( episode.getEpisode() );
        episodeDTO.setSeason( episode.getSeason() );
        episodeDTO.setLink( episode.getLink() );
        episodeDTO.setDaySubmit( episode.getDaySubmit() );

        return episodeDTO;
    }

    @Override
    public Episode episodeDtoToEpisode(EpisodeDTO episodeDTO) {
        if ( episodeDTO == null ) {
            return null;
        }

        Episode episode = new Episode();

        episode.setEpisodeId( episodeDTO.getEpisodeId() );
        episode.setName( episodeDTO.getName() );
        episode.setEpisode( episodeDTO.getEpisode() );
        episode.setSeason( episodeDTO.getSeason() );
        episode.setLink( episodeDTO.getLink() );
        episode.setDaySubmit( episodeDTO.getDaySubmit() );

        return episode;
    }

    private Integer episodeMovieMovieId(Episode episode) {
        if ( episode == null ) {
            return null;
        }
        Movie movie = episode.getMovie();
        if ( movie == null ) {
            return null;
        }
        Integer movieId = movie.getMovieId();
        if ( movieId == null ) {
            return null;
        }
        return movieId;
    }
}
