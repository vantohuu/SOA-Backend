package com.springboot.architectural.controller.user;

import com.springboot.architectural.dto.CountryDTO;
import com.springboot.architectural.dto.EpisodeDTO;
import com.springboot.architectural.payload.ResponseData;
import com.springboot.architectural.service.CountryService;
import com.springboot.architectural.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/episode")
public class EpisodeController {
    @Autowired
    EpisodeService episodeService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable(name = "id") Integer id){
        ResponseData responseData = new ResponseData();
        if (episodeService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Not found episode By ID");
            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
        }
        responseData.setData(episodeService.getById(id));
        responseData.setDesc("Get episode successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllRole(){
        ResponseData responseData = new ResponseData();
        responseData.setData(episodeService.getAll());
        responseData.setDesc("Get all successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EpisodeDTO countryDTO){
        ResponseData responseData = new ResponseData();
        responseData.setData(episodeService.add(countryDTO));
        responseData.setDesc("Create country successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody EpisodeDTO episodeDTO){
        ResponseData responseData = new ResponseData();
        if (episodeService.getById(episodeDTO.getEpisodeId()) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Update failed");
            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
        }
        responseData.setData(episodeService.update(episodeDTO));
        responseData.setDesc("Update country successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Integer id){
        ResponseData responseData = new ResponseData();
        if (episodeService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Delete failed");
            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
        }
        responseData.setData(episodeService.delete(id));
        responseData.setDesc("Delete episode successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @PostMapping("/upload")
    public ResponseEntity<?> deleteRoom(@RequestParam(name = "fileUpload") MultipartFile multipartFile, @RequestParam(name= "id")Integer id){
        ResponseData responseData = new ResponseData();
        if (episodeService.uploadVideo(multipartFile, id))
        {
            responseData.setData(true);
            responseData.setDesc("Upload person successfully");
        }
        else
        {
            responseData.setData(false);
            responseData.setDesc("Upload failed");
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}
