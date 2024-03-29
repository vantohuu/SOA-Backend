package com.springboot.architectural.controller;

import com.springboot.architectural.dto.Movie_PersonDTO;
import com.springboot.architectural.payload.ResponseData;
import com.springboot.architectural.service.MoviePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movie-person")

public class MoviePersonController {
    @Autowired
    MoviePersonService moviePersonService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable(name = "id") Integer id){
        ResponseData responseData = new ResponseData();
        if (moviePersonService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Not Found By ID");
            return new ResponseEntity<>(responseData.getData(), HttpStatus.NOT_FOUND);
        }
        responseData.setData(moviePersonService.getById(id));
        responseData.setDesc("Get successfully");
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(){
        ResponseData responseData = new ResponseData();
        responseData.setData(moviePersonService.getAll());
        responseData.setDesc("Get all successfully");
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Movie_PersonDTO moviePersonDTO){
        ResponseData responseData = new ResponseData();
        Movie_PersonDTO r = moviePersonService.add(moviePersonDTO);
        responseData.setData(r);
        responseData.setDesc("Create successfully");

        if (r == null)
        {
            responseData.setDesc("Create failed");
            responseData.setSuccess(false);
            return new ResponseEntity<>(responseData.getData(), HttpStatus.CONFLICT);

        }
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Movie_PersonDTO moviePersonDTO){
        ResponseData responseData = new ResponseData();
        System.out.println(moviePersonDTO);
        Movie_PersonDTO r = moviePersonService.update(moviePersonDTO);
        if (r == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Update failed");
            return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
        }
        responseData.setData(moviePersonService.update(moviePersonDTO));
        responseData.setDesc("Update successfully");
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRoom(@RequestParam int id){
        ResponseData responseData = new ResponseData();
        if (moviePersonService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Delete failed");

            return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
        }
        responseData.setData(moviePersonService.delete(id));
        responseData.setDesc("Delete successfully");

        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }
}
