package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.MovieDTO;
import com.springboot.architectural.dto.PersonDTO;
import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class );
    @Mapping(target = "person_id", source = "person.country.country_id")
    PersonDTO personToPersonDto(Person person);
    Person personDtoToPerson(PersonDTO personDTO);
}
