package com.springboot.architectural.controller;

import com.springboot.architectural.dto.Movie_CategoryDTO;
import com.springboot.architectural.dto.Movie_CollectionDTO;
import com.springboot.architectural.payload.ResponseData;
import com.springboot.architectural.service.MovieCategoryService;
import com.springboot.architectural.service.MovieCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/movie-collection")

public class MovieCollectionController {
    @Autowired
    MovieCollectionService movieCollectionService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable(name = "id") String id){
        ResponseData responseData = new ResponseData();
        if (movieCollectionService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Not Found By ID");
            return new ResponseEntity<>(responseData.getData(), HttpStatus.NOT_FOUND);
        }
        responseData.setData(movieCollectionService.getById(id));
        responseData.setDesc("Get successfully");
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(){
        ResponseData responseData = new ResponseData();
        responseData.setData(movieCollectionService.getAll());
        responseData.setDesc("Get all successfully");
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Movie_CollectionDTO movieCollectionDTO){
        ResponseData responseData = new ResponseData();
        Movie_CollectionDTO r = movieCollectionService.add(movieCollectionDTO);
        responseData.setData(r);
        responseData.setDesc("Create successfully");

        if (r == null)
        {
            responseData.setDesc("Create failed");

            responseData.setSuccess(false);
        }
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Movie_CollectionDTO movieCollectionDTO){
        ResponseData responseData = new ResponseData();
        System.out.println(movieCollectionDTO);
        Movie_CollectionDTO r = movieCollectionService.update(movieCollectionDTO);
        if (r == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Update failed");
            return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
        }
        responseData.setData(movieCollectionService.update(movieCollectionDTO));
        responseData.setDesc("Update successfully");
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRoom(@RequestParam String username){
        ResponseData responseData = new ResponseData();
        if (movieCollectionService.getById(username) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Delete failed");

            return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
        }
        responseData.setData(movieCollectionService.delete(username));
        responseData.setDesc("Delete successfully");

        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }
}