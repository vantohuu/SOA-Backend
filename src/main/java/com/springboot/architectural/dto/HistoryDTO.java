package com.springboot.architectural.dto;

import com.springboot.architectural.entity.Episode;
import com.springboot.architectural.entity.Movie_User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDTO {
    private Integer id;
    private Integer episodeId;
    private String username;
    private Episode episode;
    private Movie_User movieUser;
    private Long timeStamp;
}
