package com.springboot.architectural.dto;

import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Movie_User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentDTO {
    private Integer idComment;
    private Integer movieId;
    private String username;
    private String name;
    private String avatar;
    private String comment;
    private Integer value;
    private Date date;
}
