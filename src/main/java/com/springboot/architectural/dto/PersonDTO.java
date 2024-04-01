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
    private Integer personId;
    private String name;
    private Boolean gender;
    private Date dayOfBirth;
    private String image;
    private String describe;
    private Integer countryId;
    private CountryDTO country;
}
