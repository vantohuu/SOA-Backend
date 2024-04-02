package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.CountryDTO;
import com.springboot.architectural.dto.PersonDTO;
import com.springboot.architectural.entity.Country;
import com.springboot.architectural.entity.Person;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-02T14:53:49+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonDTO personToPersonDto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setCountryId( personCountryCountryId( person ) );
        personDTO.setPersonId( person.getPersonId() );
        personDTO.setName( person.getName() );
        personDTO.setGender( person.getGender() );
        personDTO.setDayOfBirth( person.getDayOfBirth() );
        personDTO.setImage( person.getImage() );
        personDTO.setDescribe( person.getDescribe() );
        personDTO.setCountry( countryToCountryDTO( person.getCountry() ) );

        return personDTO;
    }

    @Override
    public Person personDtoToPerson(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        Person person = new Person();

        person.setPersonId( personDTO.getPersonId() );
        person.setName( personDTO.getName() );
        person.setGender( personDTO.getGender() );
        person.setDayOfBirth( personDTO.getDayOfBirth() );
        person.setImage( personDTO.getImage() );
        person.setDescribe( personDTO.getDescribe() );
        person.setCountry( countryDTOToCountry( personDTO.getCountry() ) );

        return person;
    }

    private Integer personCountryCountryId(Person person) {
        if ( person == null ) {
            return null;
        }
        Country country = person.getCountry();
        if ( country == null ) {
            return null;
        }
        Integer countryId = country.getCountryId();
        if ( countryId == null ) {
            return null;
        }
        return countryId;
    }

    protected CountryDTO countryToCountryDTO(Country country) {
        if ( country == null ) {
            return null;
        }

        CountryDTO countryDTO = new CountryDTO();

        countryDTO.setCountryId( country.getCountryId() );
        countryDTO.setName( country.getName() );

        return countryDTO;
    }

    protected Country countryDTOToCountry(CountryDTO countryDTO) {
        if ( countryDTO == null ) {
            return null;
        }

        Country country = new Country();

        country.setCountryId( countryDTO.getCountryId() );
        country.setName( countryDTO.getName() );

        return country;
    }
}
