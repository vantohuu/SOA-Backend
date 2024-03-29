package com.springboot.architectural.service.imp;

import com.springboot.architectural.dto.HistoryDTO;
import com.springboot.architectural.entity.Episode;
import com.springboot.architectural.entity.History;
import com.springboot.architectural.entity.Movie_User;
import com.springboot.architectural.mapper.HistoryMapper;
import com.springboot.architectural.repository.*;
import com.springboot.architectural.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HistoryServiceImp implements HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private MovieUserRepository movieUserRepository;
    @Autowired
    private EpisodeRepository episodeRepository;

    @Override
    public HistoryDTO getById(int id) {
        Optional<History> history = historyRepository.findById(id);
        return history.map(HistoryMapper.INSTANCE::historyToHistoryDto).orElse(null);
    }

    public List<HistoryDTO> getAll() {
        List<History> histories = historyRepository.findAll();
        return histories.stream().map(HistoryMapper.INSTANCE::historyToHistoryDto).collect(Collectors.toList());
    }

    @Override
    public HistoryDTO add(HistoryDTO historyDTO) {
        History entity = HistoryMapper.INSTANCE.historyDtoToHistory(historyDTO);
        if (historyDTO.getEpisodeId() == null || historyDTO.getUsername() == null) return null;
        Optional<Episode> episode = episodeRepository.findById(historyDTO.getEpisodeId());
        Optional<Movie_User> movieUser = movieUserRepository.findById(historyDTO.getUsername());
        if (episode.isEmpty() || movieUser.isEmpty()) return null;
        entity.setEpisode(episode.get());
        entity.setMovieUser(movieUser.get());
        return  HistoryMapper.INSTANCE.historyToHistoryDto(historyRepository.save(entity));
    }

    @Override
    public HistoryDTO update(HistoryDTO historyDTO) {
        if (historyDTO.getId() == null) return  null;
        Optional<History> checkRR = historyRepository.findById(historyDTO.getId());
        if (checkRR.isEmpty()) return null;
        History entity = HistoryMapper.INSTANCE.historyDtoToHistory(historyDTO);
        if (historyDTO.getEpisodeId() == null || historyDTO.getUsername() == null) return null;
        Optional<Episode> episode = episodeRepository.findById(historyDTO.getEpisodeId());
        Optional<Movie_User> movieUser = movieUserRepository.findById(historyDTO.getUsername());
        if (episode.isEmpty() || movieUser.isEmpty()) return null;
        entity.setEpisode(episode.get());
        entity.setMovieUser(movieUser.get());
        return  HistoryMapper.INSTANCE.historyToHistoryDto(historyRepository.save(entity));
    }

    @Override
    public boolean delete(Integer id) {
        Optional<History> c = historyRepository.findById(id);
        if (c.isPresent())
        {
            historyRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
