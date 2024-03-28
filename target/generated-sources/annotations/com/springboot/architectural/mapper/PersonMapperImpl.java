package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.PersonDTO;
import com.springboot.architectural.entity.Person;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-28T15:12:45+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonDTO personToPersonDto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setPerson_id( person.getPerson_id() );
        personDTO.setName( person.getName() );
        personDTO.setGender( person.getGender() );
        personDTO.setDay_of_birth( person.getDay_of_birth() );
        personDTO.setImage( person.getImage() );
        personDTO.setDescribe( person.getDescribe() );
        personDTO.setCountry( person.getCountry() );

        return personDTO;
    }

    @Override
    public Person personDtoToPerson(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        Person person = new Person();

        person.setPerson_id( personDTO.getPerson_id() );
        person.setName( personDTO.getName() );
        person.setGender( personDTO.getGender() );
        person.setDay_of_birth( personDTO.getDay_of_birth() );
        person.setImage( personDTO.getImage() );
        person.setDescribe( personDTO.getDescribe() );
        person.setCountry( personDTO.getCountry() );

        return person;
    }
}
