package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.CategoryDTO;
import com.springboot.architectural.dto.CountryDTO;
import com.springboot.architectural.dto.EpisodeDTO;
import com.springboot.architectural.dto.MovieDTO;
import com.springboot.architectural.dto.PersonDTO;
import com.springboot.architectural.entity.Category;
import com.springboot.architectural.entity.Country;
import com.springboot.architectural.entity.Episode;
import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Person;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-13T07:35:54+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class MovieMapperImpl implements MovieMapper {

    @Override
    public MovieDTO movieToMovieDto(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        MovieDTO movieDTO = new MovieDTO();

        movieDTO.setCountryId( movieCountryCountryId( movie ) );
        movieDTO.setMovieId( movie.getMovieId() );
        movieDTO.setName( movie.getName() );
        movieDTO.setMovieContent( movie.getMovieContent() );
        movieDTO.setEpisodes( movie.getEpisodes() );
        movieDTO.setMovieSchedule( movie.getMovieSchedule() );
        movieDTO.setImage( movie.getImage() );
        movieDTO.setCountry( movie.getCountry() );
        movieDTO.setStar( movie.getStar() );
        movieDTO.setPrice( movie.getPrice() );
        movieDTO.setViews( movie.getViews() );
        movieDTO.setStatus( movie.getStatus() );
        movieDTO.setEpisodeList( episodeListToEpisodeDTOList( movie.getEpisodeList() ) );
        movieDTO.setCategories( categorySetToCategoryDTOList( movie.getCategories() ) );
        movieDTO.setPersons( personSetToPersonDTOList( movie.getPersons() ) );

        return movieDTO;
    }

    @Override
    public Movie movieDtoToMovie(MovieDTO movieDTO) {
        if ( movieDTO == null ) {
            return null;
        }

        Movie movie = new Movie();

        movie.setMovieId( movieDTO.getMovieId() );
        movie.setName( movieDTO.getName() );
        movie.setMovieContent( movieDTO.getMovieContent() );
        movie.setEpisodes( movieDTO.getEpisodes() );
        movie.setMovieSchedule( movieDTO.getMovieSchedule() );
        movie.setImage( movieDTO.getImage() );
        movie.setCountry( movieDTO.getCountry() );
        movie.setStar( movieDTO.getStar() );
        movie.setPrice( movieDTO.getPrice() );
        movie.setViews( movieDTO.getViews() );
        movie.setStatus( movieDTO.getStatus() );
        movie.setEpisodeList( episodeDTOListToEpisodeList( movieDTO.getEpisodeList() ) );
        movie.setCategories( categoryDTOListToCategorySet( movieDTO.getCategories() ) );
        movie.setPersons( personDTOListToPersonSet( movieDTO.getPersons() ) );

        return movie;
    }

    private Integer movieCountryCountryId(Movie movie) {
        if ( movie == null ) {
            return null;
        }
        Country country = movie.getCountry();
        if ( country == null ) {
            return null;
        }
        Integer countryId = country.getCountryId();
        if ( countryId == null ) {
            return null;
        }
        return countryId;
    }

    protected EpisodeDTO episodeToEpisodeDTO(Episode episode) {
        if ( episode == null ) {
            return null;
        }

        EpisodeDTO episodeDTO = new EpisodeDTO();

        episodeDTO.setEpisodeId( episode.getEpisodeId() );
        episodeDTO.setName( episode.getName() );
        episodeDTO.setEpisode( episode.getEpisode() );
        episodeDTO.setSeason( episode.getSeason() );
        episodeDTO.setLink( episode.getLink() );
        episodeDTO.setDaySubmit( episode.getDaySubmit() );

        return episodeDTO;
    }

    protected List<EpisodeDTO> episodeListToEpisodeDTOList(List<Episode> list) {
        if ( list == null ) {
            return null;
        }

        List<EpisodeDTO> list1 = new ArrayList<EpisodeDTO>( list.size() );
        for ( Episode episode : list ) {
            list1.add( episodeToEpisodeDTO( episode ) );
        }

        return list1;
    }

    protected CategoryDTO categoryToCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setCategoryId( category.getCategoryId() );
        categoryDTO.setName( category.getName() );

        return categoryDTO;
    }

    protected List<CategoryDTO> categorySetToCategoryDTOList(Set<Category> set) {
        if ( set == null ) {
            return null;
        }

        List<CategoryDTO> list = new ArrayList<CategoryDTO>( set.size() );
        for ( Category category : set ) {
            list.add( categoryToCategoryDTO( category ) );
        }

        return list;
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

    protected PersonDTO personToPersonDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setPersonId( person.getPersonId() );
        personDTO.setName( person.getName() );
        personDTO.setGender( person.getGender() );
        personDTO.setDayOfBirth( person.getDayOfBirth() );
        personDTO.setImage( person.getImage() );
        personDTO.setDescribe( person.getDescribe() );
        personDTO.setCountry( countryToCountryDTO( person.getCountry() ) );

        return personDTO;
    }

    protected List<PersonDTO> personSetToPersonDTOList(Set<Person> set) {
        if ( set == null ) {
            return null;
        }

        List<PersonDTO> list = new ArrayList<PersonDTO>( set.size() );
        for ( Person person : set ) {
            list.add( personToPersonDTO( person ) );
        }

        return list;
    }

    protected Episode episodeDTOToEpisode(EpisodeDTO episodeDTO) {
        if ( episodeDTO == null ) {
            return null;
        }

        Episode episode = new Episode();

        episode.setEpisodeId( episodeDTO.getEpisodeId() );
        episode.setName( episodeDTO.getName() );
        episode.setEpisode( episodeDTO.getEpisode() );
        episode.setSeason( episodeDTO.getSeason() );
        episode.setLink( episodeDTO.getLink() );
        episode.setDaySubmit( episodeDTO.getDaySubmit() );

        return episode;
    }

    protected List<Episode> episodeDTOListToEpisodeList(List<EpisodeDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Episode> list1 = new ArrayList<Episode>( list.size() );
        for ( EpisodeDTO episodeDTO : list ) {
            list1.add( episodeDTOToEpisode( episodeDTO ) );
        }

        return list1;
    }

    protected Category categoryDTOToCategory(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setCategoryId( categoryDTO.getCategoryId() );
        category.setName( categoryDTO.getName() );

        return category;
    }

    protected Set<Category> categoryDTOListToCategorySet(List<CategoryDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<Category> set = new HashSet<Category>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( CategoryDTO categoryDTO : list ) {
            set.add( categoryDTOToCategory( categoryDTO ) );
        }

        return set;
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

    protected Person personDTOToPerson(PersonDTO personDTO) {
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

    protected Set<Person> personDTOListToPersonSet(List<PersonDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<Person> set = new HashSet<Person>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( PersonDTO personDTO : list ) {
            set.add( personDTOToPerson( personDTO ) );
        }

        return set;
    }
}
