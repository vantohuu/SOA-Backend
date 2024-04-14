package com.springboot.architectural.service;

import com.springboot.architectural.dto.CountryDTO;
import com.springboot.architectural.dto.EpisodeDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EpisodeService {
    EpisodeDTO getById(int id);
    List<EpisodeDTO> getAll();
    EpisodeDTO add(EpisodeDTO episodeDTO);
    EpisodeDTO update(EpisodeDTO episodeDTO);
    boolean delete(Integer id);

    boolean uploadVideo(MultipartFile multipartFile, Integer id);
}
