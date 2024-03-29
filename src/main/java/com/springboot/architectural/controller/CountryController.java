package com.springboot.architectural.controller;

import com.springboot.architectural.dto.CountryDTO;
import com.springboot.architectural.payload.ResponseData;
import com.springboot.architectural.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    @Autowired
    CountryService countryService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable(name = "id") Integer id){
        ResponseData responseData = new ResponseData();
        if (countryService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Not found country By ID");
            return new ResponseEntity<>(responseData.getData(), HttpStatus.NOT_FOUND);
        }
        responseData.setData(countryService.getById(id));
        responseData.setDesc("Get country successfully");
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllRole(){
        ResponseData responseData = new ResponseData();
        responseData.setData(countryService.getAll());
        responseData.setDesc("Get all successfully");
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CountryDTO countryDTO){
        ResponseData responseData = new ResponseData();
        responseData.setData(countryService.add(countryDTO));
        responseData.setDesc("Create country successfully");
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody CountryDTO countryDTO){
        ResponseData responseData = new ResponseData();
        if (countryService.getById(countryDTO.getCountryId()) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Update failed");
            return new ResponseEntity<>(responseData.getData(), HttpStatus.NOT_FOUND);
        }
        responseData.setData(countryService.update(countryDTO));
        responseData.setDesc("Update country successfully");
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Integer id){
        ResponseData responseData = new ResponseData();
        if (countryService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Delete failed");

            return new ResponseEntity<>(responseData.getData(), HttpStatus.NOT_FOUND);
        }
        responseData.setData(countryService.delete(id));
        responseData.setDesc("Delete country successfully");
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }



}
