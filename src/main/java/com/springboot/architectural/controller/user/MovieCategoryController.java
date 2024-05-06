package com.springboot.architectural.controller.user;

import com.springboot.architectural.dto.Movie_CategoryDTO;
import com.springboot.architectural.dto.PersonDTO;
import com.springboot.architectural.payload.ResponseData;
import com.springboot.architectural.service.MovieCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/movie-category")

public class MovieCategoryController {
    @Autowired
    MovieCategoryService movieCategoryService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable(name = "id") Integer id){
        ResponseData responseData = new ResponseData();
        if (movieCategoryService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Not Found By ID");
            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
        }
        responseData.setData(movieCategoryService.getById(id));
        responseData.setDesc("Get successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(){
        ResponseData responseData = new ResponseData();
        responseData.setData(movieCategoryService.getAll());
        responseData.setDesc("Get all successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Movie_CategoryDTO movieCategoryDTO){
        ResponseData responseData = new ResponseData();
        Movie_CategoryDTO r = movieCategoryService.add(movieCategoryDTO);
        responseData.setData(r);
        responseData.setDesc("Create successfully");
        if (r == null)
        {
            responseData.setDesc("Create failed");
            responseData.setSuccess(false);
            return new ResponseEntity<>(responseData, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Movie_CategoryDTO movieCategoryDTO){
        ResponseData responseData = new ResponseData();
        System.out.println(movieCategoryDTO);
        Movie_CategoryDTO r = movieCategoryService.update(movieCategoryDTO);
        if (r == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Update failed");
            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
        }
        responseData.setData(movieCategoryService.update(movieCategoryDTO));
        responseData.setDesc("Update successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRoom(@RequestParam int id){
        ResponseData responseData = new ResponseData();
        if (movieCategoryService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Delete failed");

            return new ResponseEntity<>(responseData, HttpStatus.OK);
        }
        responseData.setData(movieCategoryService.delete(id));
        responseData.setDesc("Delete successfully");

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
