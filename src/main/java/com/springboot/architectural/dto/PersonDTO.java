package com.springboot.architectural.dto;

import com.springboot.architectural.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonDTO {
    private Integer person_id;
    private String name;
    private Integer gender;
    private Date day_of_birth;
    private String image;
    private String describe;
    private Integer country_id;
    private Country country;
}
