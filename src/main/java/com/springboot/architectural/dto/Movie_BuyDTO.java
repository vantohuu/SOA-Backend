package com.springboot.architectural.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie_BuyDTO {
    private Integer id;
    private Integer movieId;
    private String movieName;
    private String imageMovie;
    private String username;
    private Date time;
}
