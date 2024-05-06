package com.springboot.architectural.controller.admin;

import com.springboot.architectural.dto.Movie_CollectionDTO;
import com.springboot.architectural.payload.ResponseData;
import com.springboot.architectural.service.MovieCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/admin/movie-collection")

public class AdminMovieCollectionController {
    @Autowired
    MovieCollectionService movieCollectionService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable(name = "id") Integer id){
        ResponseData responseData = new ResponseData();
        if (movieCollectionService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Not Found By ID");
            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
        }
        responseData.setData(movieCollectionService.getById(id));
        responseData.setDesc("Get successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(){
        ResponseData responseData = new ResponseData();
        responseData.setData(movieCollectionService.getAll());
        responseData.setDesc("Get all successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @GetMapping("/get-all-by-user")
    public ResponseEntity<?> getAllByUser(@RequestParam String username){
        ResponseData responseData = new ResponseData();
        List<Movie_CollectionDTO> list = movieCollectionService.getAllByMovieUser(username);
        if (list.isEmpty())   return new ResponseEntity<>(Collections.singletonMap("data", list), HttpStatus.NOT_FOUND);
        responseData.setData(list);
        responseData.setDesc("Get all by username successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
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
            return new ResponseEntity<>(responseData, HttpStatus.CONFLICT);

        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
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
            return new ResponseEntity<>(responseData, HttpStatus.OK);
        }
        responseData.setData(movieCollectionService.update(movieCollectionDTO));
        responseData.setDesc("Update successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Integer id){
        ResponseData responseData = new ResponseData();
        if (movieCollectionService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Delete failed");

            return new ResponseEntity<>(responseData, HttpStatus.OK);
        }
        responseData.setData(movieCollectionService.delete(id));
        responseData.setDesc("Delete successfully");

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @DeleteMapping("/delete-by-movie-and-user")
    public ResponseEntity<?> deleteByMovieAndUser(@RequestParam Integer movieId, @RequestParam String username){
        ResponseData responseData = new ResponseData();
        boolean checkDeleted = movieCollectionService.deleteCollectionByMovieAndUser(movieId, username);
        responseData.setData(checkDeleted);
        responseData.setDesc("Delete successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @GetMapping("check-exists-collection")
    public ResponseEntity<?> check(@RequestParam Integer movieId,@RequestParam String username ){
        ResponseData responseData = new ResponseData();
        responseData.setData(movieCollectionService.checkMovieCollectionIsExists(movieId, username));
        responseData.setDesc("check successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
