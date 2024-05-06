package com.springboot.architectural.controller.admin;

import com.springboot.architectural.dto.Movie_BuyDTO;
import com.springboot.architectural.payload.ResponseData;
import com.springboot.architectural.service.MovieBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/movie-buy")
public class AdminMovieBuyController {
    @Autowired
    MovieBuyService movieBuyService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable(name = "id") Integer id){
        ResponseData responseData = new ResponseData();
        if (movieBuyService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Not Found By ID");
            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
        }
        responseData.setData(movieBuyService.getById(id));
        responseData.setDesc("Get successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(){
        ResponseData responseData = new ResponseData();
        responseData.setData(movieBuyService.getAll());
        responseData.setDesc("Get all successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @GetMapping("/get-all-by-user")
    public ResponseEntity<?> getAllByUser(@RequestParam String username){
        ResponseData responseData = new ResponseData();
        List<Movie_BuyDTO> list = movieBuyService.getAllByMovieUser(username);
        responseData.setData(list);
        if (list.isEmpty())   return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
        responseData.setDesc("Get all by username successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Movie_BuyDTO movieCollectionDTO){
        ResponseData responseData = new ResponseData();
        Movie_BuyDTO r = movieBuyService.add(movieCollectionDTO);
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
    public ResponseEntity<?> update(@RequestBody Movie_BuyDTO movieBuyDTO){
        ResponseData responseData = new ResponseData();
        System.out.println(movieBuyDTO);
        Movie_BuyDTO r = movieBuyService.update(movieBuyDTO);
        if (r == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Update failed");
            return new ResponseEntity<>(responseData, HttpStatus.OK);
        }
        responseData.setData(movieBuyService.update(movieBuyDTO));
        responseData.setDesc("Update successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Integer id){
        ResponseData responseData = new ResponseData();
        if (movieBuyService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Delete failed");

            return new ResponseEntity<>(responseData, HttpStatus.OK);
        }
        responseData.setData(movieBuyService.delete(id));
        responseData.setDesc("Delete successfully");

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @DeleteMapping("/delete-by-movie-and-user")
    public ResponseEntity<?> deleteByMovieAndUser(@RequestParam Integer movieId, @RequestParam String username){
        ResponseData responseData = new ResponseData();
        boolean checkDeleted = movieBuyService.deleteMovieBuyByMovieAndUser(movieId, username);
        responseData.setData(checkDeleted);
        responseData.setDesc("Delete successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @GetMapping("check-exists-buy")
    public ResponseEntity<?> check(@RequestParam Integer movieId,@RequestParam String username ){
        ResponseData responseData = new ResponseData();
        responseData.setData(movieBuyService.checkMovieBuyIsExists(movieId, username));
        responseData.setDesc("check successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
