package com.springboot.architectural.dto;

import com.springboot.architectural.entity.*;
import com.springboot.architectural.dto.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private Integer movie_id;
    private String name;
    private String movie_content;
    private Integer episodes;
    private Integer movie_schedule;
    private String image;
    private Integer country_id;
    private Country country;
    private  float star;
    private Integer price;
    private Integer views;
    private Integer status;
    private List<EpisodeDTO> episodeList;
    private List<CategoryDTO> categories;
    private List<PersonDTO> persons;
}
