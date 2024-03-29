package com.springboot.architectural.service.imp;

import com.springboot.architectural.dto.MovieDTO;
import com.springboot.architectural.dto.PersonDTO;
import com.springboot.architectural.entity.Country;
import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Person;
import com.springboot.architectural.mapper.MovieMapper;
import com.springboot.architectural.mapper.PersonMapper;
import com.springboot.architectural.repository.CountryRepository;
import com.springboot.architectural.repository.MovieRepository;
import com.springboot.architectural.repository.PersonRepository;
import com.springboot.architectural.service.FileService;
import com.springboot.architectural.service.MovieService;
import com.springboot.architectural.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImp implements PersonService {
    @Value("${fileUpload.rootPatch}")
    private String rootPatch;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private FileService fileService;
    @Override
    public PersonDTO getById(Integer id) {
        Optional<Person> entity = personRepository.findById(id);
        return entity.map(PersonMapper.INSTANCE::personToPersonDto).orElse(null);
    }

    @Override
    public List<PersonDTO> getAll(String searchContent,String sortField, String typeSort) {
        Sort sorted = Sort.by(sortField);
        sorted = typeSort.equals("asc") ? sorted.ascending() : sorted.descending();
        List<Person> list =  personRepository.findAllFilter(searchContent, sorted);;
        return list.stream().map(PersonMapper.INSTANCE::personToPersonDto).collect(Collectors.toList());
    }

    @Override
    public PersonDTO add(PersonDTO personDTO) {
        Person entity = PersonMapper.INSTANCE.personDtoToPerson(personDTO);
        entity.setCountry(countryRepository.findById(entity.getCountry().getCountryId()).get());
        return  PersonMapper.INSTANCE.personToPersonDto(personRepository.save(entity));
    }

    @Override
    public PersonDTO update(PersonDTO personDTO) {
        if (personDTO.getPersonId() == null) return null;
        Optional<Person> personCheck = personRepository.findById(personDTO.getPersonId());
        Optional<Country> countryCheck = countryRepository.findById(personDTO.getCountryId());
        if (personCheck.isEmpty() || countryCheck.isEmpty()) return  null;
        Person entity = PersonMapper.INSTANCE.personDtoToPerson(personDTO);
        entity.setCountry(countryCheck.orElse(null));
        return  PersonMapper.INSTANCE.personToPersonDto(personRepository.save(entity));
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Person> r = personRepository.findById(id);
        if (r.isPresent())
        {
            personRepository.delete(r.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean uploadImg(MultipartFile multipartFile, Integer id) {
        Optional<Person> p = personRepository.findById(id);
        if (p.isEmpty()) return  false;
        String url =  rootPatch + "/" + multipartFile.getOriginalFilename();
        p.get().setImage(url);
        personRepository.save(p.get());
        return fileService.save(multipartFile);
    }
}
