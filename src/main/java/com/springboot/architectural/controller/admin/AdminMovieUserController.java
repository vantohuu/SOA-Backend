package com.springboot.architectural.controller.admin;

import com.springboot.architectural.dto.Movie_UserDTO;
import com.springboot.architectural.payload.Request.ChangePassRequest;
import com.springboot.architectural.payload.ResponseData;
import com.springboot.architectural.service.LoginService;
import com.springboot.architectural.service.MovieUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;

@RestController
@RequestMapping("/api/admin/movie-user")

public class AdminMovieUserController {
    @Autowired
    MovieUserService movieUserService;
    @Autowired
    LoginService loginService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getMovieUser(@PathVariable(name = "id") String id){
        ResponseData responseData = new ResponseData();
        if (movieUserService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Not Found MovieUser By ID");
            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
        }
        responseData.setData(movieUserService.getById(id));
        responseData.setDesc("Get movieUser successfully");

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "") String sortField,
                                        @RequestParam(defaultValue = "DESC") String typeSort,
                                        @RequestParam(defaultValue = "") String searchContent){
        ResponseData responseData = new ResponseData();
        responseData.setData(movieUserService.getAll(searchContent, sortField, typeSort));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @PostMapping("/change-pass")
    public ResponseEntity<?> changePass(@RequestBody ChangePassRequest changePassRequest){
        ResponseData responseData = new ResponseData();
        responseData.setData(loginService.changePassByOldPass(changePassRequest));
        responseData.setDesc("Change pass movieUser successfully");
        return new ResponseEntity<>(Collections.singletonMap("status",responseData), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Movie_UserDTO movieUserDTO){
        ResponseData responseData = new ResponseData();
        responseData.setData(movieUserService.add(movieUserDTO));
        responseData.setDesc("Create movieUser successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateRoom(@RequestBody Movie_UserDTO movieUserDTO){
        ResponseData responseData = new ResponseData();
        if (movieUserService.getById(movieUserDTO.getUsername()) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Update failed");
            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
        }
        responseData.setData(movieUserService.update(movieUserDTO));
        responseData.setDesc("Update movie successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRoom(@RequestParam String username){
        ResponseData responseData = new ResponseData();
        if (movieUserService.getById(username) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Delete failed");

            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
        }
        responseData.setData(movieUserService.delete(username));
        responseData.setDesc("Delete room successfully");

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> deleteRoom(@RequestParam(name = "fileUpload")MultipartFile multipartFile, @RequestParam(name= "username")String username){
        ResponseData responseData = new ResponseData();
        if (movieUserService.uploadImg(multipartFile, username))
        {
            responseData.setData(true);
            responseData.setDesc("Upload avatar successfully");
        }
        else
        {
            responseData.setData(false);
            responseData.setDesc("Upload failed");
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
