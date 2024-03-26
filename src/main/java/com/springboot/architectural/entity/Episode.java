package com.springboot.architectural.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@Table(name = "Episode")
@NoArgsConstructor
@AllArgsConstructor
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer episode_id;
    private String name;
    private Integer episode;
    private String season;
    private String link;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    private Date day_submit;
}
