package com.springboot.architectural.service.imp;

import com.springboot.architectural.dto.EpisodeDTO;
import com.springboot.architectural.entity.Episode;
import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.mapper.EpisodeMapper;
import com.springboot.architectural.repository.EpisodeRepository;
import com.springboot.architectural.repository.MovieRepository;
import com.springboot.architectural.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EpisodeServiceImp implements EpisodeService {
    @Autowired
    private EpisodeRepository episodeRepository;
    @Autowired
    private MovieRepository movieRepository;


    @Override
    public EpisodeDTO getById(int id) {
        Optional<Episode> country = episodeRepository.findById(id);
        return country.map(EpisodeMapper.INSTANCE::episodeToEpisodeDto).orElse(null);
    }

    public List<EpisodeDTO> getAll() {
        List<Episode> episodes = episodeRepository.findAll();
        return episodes.stream().map(EpisodeMapper.INSTANCE::episodeToEpisodeDto).collect(Collectors.toList());
    }

    @Override
    public EpisodeDTO add(EpisodeDTO episodeDTO) {
        Episode entity = EpisodeMapper.INSTANCE.episodeDtoToEpisode(episodeDTO);
        if (episodeDTO.getName() == null ) return null;
        Optional<Movie> movie = movieRepository.findById(episodeDTO.getMovieId());
        if (movie.isEmpty()) return null;
        entity.setMovie(movie.get());
        return  EpisodeMapper.INSTANCE.episodeToEpisodeDto(episodeRepository.save(entity));
    }

    @Override
    public EpisodeDTO update(EpisodeDTO episodeDTO) {
        Optional<Episode> checkRR = episodeRepository.findById(episodeDTO.getEpisodeId());
        if (checkRR.isEmpty()) return null;
        Optional<Movie> movie = movieRepository.findById(episodeDTO.getMovieId());
        if (movie.isEmpty()) return null;
        Episode entity = EpisodeMapper.INSTANCE.episodeDtoToEpisode(episodeDTO);
        entity.setMovie(movie.get());
        return  EpisodeMapper.INSTANCE.episodeToEpisodeDto(episodeRepository.save(entity));
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Episode> c = episodeRepository.findById(id);
        if (c.isPresent())
        {
            episodeRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
