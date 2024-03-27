package com.springboot.architectural.controller;

import com.springboot.architectural.dto.CategoryDTO;
import com.springboot.architectural.dto.RoleDTO;
import com.springboot.architectural.payload.ResponseData;
import com.springboot.architectural.service.CategoryService;
import com.springboot.architectural.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable(name = "id") Integer id){
        ResponseData responseData = new ResponseData();
        if (categoryService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Not Found Category By ID");
            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
        }
        responseData.setData(categoryService.getById(id));
        responseData.setDesc("Get Category successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllRole(){
        ResponseData responseData = new ResponseData();
        responseData.setData(categoryService.getAll());
        responseData.setDesc("Get all successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CategoryDTO categoryDTO){
        ResponseData responseData = new ResponseData();
        responseData.setData(categoryService.add(categoryDTO));
        responseData.setDesc("Create category successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody CategoryDTO categoryDTO){
        ResponseData responseData = new ResponseData();
        if (categoryService.getById(categoryDTO.getCategory_id()) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Update failed");
            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
        }
        responseData.setData(categoryService.update(categoryDTO));
        responseData.setDesc("Update category successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Integer id){
        ResponseData responseData = new ResponseData();
        if (categoryService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Delete failed");

            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
        }
        responseData.setData(categoryService.delete(id));
        responseData.setDesc("Delete category successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }



}
