package com.springboot.architectural.service;

import com.springboot.architectural.dto.MovieDTO;
import com.springboot.architectural.dto.PersonDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PersonService {
    PersonDTO getById(Integer id);
    List<PersonDTO> getAll(String searchContent,String sortField,  String typeSort);
    PersonDTO add(PersonDTO personDTO);
    PersonDTO update(PersonDTO personDTO);
    boolean delete(Integer id);

    boolean uploadImg(MultipartFile multipartFile, Integer person_id);
}
