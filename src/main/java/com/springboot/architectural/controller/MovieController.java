package com.springboot.architectural.controller;

import com.springboot.architectural.dto.MovieDTO;
import com.springboot.architectural.payload.ResponseData;
import com.springboot.architectural.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/movie")

public class MovieController {
    @Autowired
    MovieService movieService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getRoom(@PathVariable(name = "id") Integer id){
        ResponseData responseData = new ResponseData();
        if (movieService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Not Found Movie By ID");
            return new ResponseEntity<>(responseData.getData(), HttpStatus.NOT_FOUND);
        }
        responseData.setData(movieService.getById(id));
        responseData.setDesc("Get movie successfully");

        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "") String sortField,
                                        @RequestParam(defaultValue = "DESC") String typeSort,
                                        @RequestParam(defaultValue = "") String searchContent){
        ResponseData responseData = new ResponseData();
        responseData.setData(movieService.getAll(searchContent, sortField, typeSort));
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }
    @GetMapping("/get-all-by-category")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "") String sortField,
                                    @RequestParam(defaultValue = "DESC") String typeSort,
                                    @RequestParam(defaultValue = "") String searchContent,
                                    @RequestParam(defaultValue = "") Integer category_id){
        ResponseData responseData = new ResponseData();
        responseData.setData(movieService.getAllByCategory(searchContent, sortField, typeSort,category_id));
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createRoom(@RequestBody MovieDTO movie){
        ResponseData responseData = new ResponseData();
        responseData.setData(movieService.add(movie));
        responseData.setDesc("Create movie successfully");
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateRoom(@RequestBody MovieDTO movie){
        ResponseData responseData = new ResponseData();
        if (movieService.getById(movie.getMovie_id()) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Update failed");
            return new ResponseEntity<>(responseData.getData(), HttpStatus.NOT_FOUND);
        }
        responseData.setData(movieService.update(movie));
        responseData.setDesc("Update movie successfully");
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRoom(@RequestParam int id){
        ResponseData responseData = new ResponseData();
        if (movieService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Delete failed");

            return new ResponseEntity<>(responseData.getData(), HttpStatus.NOT_FOUND);
        }
        responseData.setData(movieService.delete(id));
        responseData.setDesc("Delete successfully");

        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> deleteRoom(@RequestParam(name = "fileUpload")MultipartFile multipartFile, @RequestParam(name= "id")Integer id){
        ResponseData responseData = new ResponseData();
        if (movieService.uploadImg(multipartFile, id))
        {
            responseData.setData(true);
            responseData.setDesc("Upload movie successfully");
        }
        else
        {
            responseData.setData(false);
            responseData.setDesc("Upload failed");
        }
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }

}
