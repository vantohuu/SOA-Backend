package com.springboot.architectural.controller;

import com.springboot.architectural.dto.MovieDTO;
import com.springboot.architectural.dto.PersonDTO;
import com.springboot.architectural.payload.ResponseData;
import com.springboot.architectural.service.MovieService;
import com.springboot.architectural.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/person")

public class PersonController {
    @Autowired
    PersonService personService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getRoom(@PathVariable(name = "id") Integer id){
        ResponseData responseData = new ResponseData();
        if (personService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Not Found person By ID");
            return new ResponseEntity<>(responseData.getData(), HttpStatus.NOT_FOUND);
        }
        responseData.setData(personService.getById(id));
        responseData.setDesc("Get person successfully");

        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "") String sortField,
                                        @RequestParam(defaultValue = "DESC") String typeSort,
                                        @RequestParam(defaultValue = "") String searchContent){
        ResponseData responseData = new ResponseData();
        responseData.setData(personService.getAll(searchContent, sortField, typeSort));
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createRoom(@RequestBody PersonDTO person){
        ResponseData responseData = new ResponseData();
        PersonDTO reposeDTO = personService.add(person);
        if (reposeDTO == null) return new ResponseEntity<>(responseData.getData(), HttpStatus.NOT_FOUND);
        responseData.setData(reposeDTO);
        responseData.setDesc("Create person successfully");
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateRoom(@RequestBody PersonDTO person){
        ResponseData responseData = new ResponseData();
        if (personService.getById(person.getPersonId()) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Update failed");
            return new ResponseEntity<>(responseData.getData(), HttpStatus.NOT_FOUND);
        }
        PersonDTO reposeDTO = personService.update(person);
        if (reposeDTO == null) return new ResponseEntity<>(responseData.getData(), HttpStatus.NOT_FOUND);
        responseData.setData(reposeDTO);
        responseData.setDesc("Update person successfully");
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRoom(@RequestParam int id){
        ResponseData responseData = new ResponseData();
        if (personService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Delete failed");

            return new ResponseEntity<>(responseData.getData(), HttpStatus.NOT_FOUND);
        }
        responseData.setData(personService.delete(id));
        responseData.setDesc("Delete person successfully");
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> deleteRoom(@RequestParam(name = "fileUpload")MultipartFile multipartFile, @RequestParam(name= "personId")Integer personId){
        ResponseData responseData = new ResponseData();
        if (personService.uploadImg(multipartFile, personId))
        {
            responseData.setData(true);
            responseData.setDesc("Upload person successfully");
        }
        else
        {
            responseData.setData(false);
            responseData.setDesc("Upload failed");
        }
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }



}
