package com.springboot.architectural.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeDTO {
    private Integer episodeId;
    private String name;
    private Integer episode;
    private String season;
    private String link;
    private Date daySubmit;
    private Integer movieId;
}
