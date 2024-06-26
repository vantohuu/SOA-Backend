package com.springboot.architectural.controller.admin;

import com.springboot.architectural.dto.RoleDTO;
import com.springboot.architectural.payload.ResponseData;
import com.springboot.architectural.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/role")
public class AdminRoleController {
    @Autowired
    RoleService roleService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable(name = "id") Integer id){
        ResponseData responseData = new ResponseData();
        if (roleService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Not Found Role By ID");
            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
        }
        responseData.setData(roleService.getById(id));
        responseData.setDesc("Get Role successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/get-all-role")
    public ResponseEntity<?> getAllRole(){
        ResponseData responseData = new ResponseData();
        responseData.setData(roleService.getAll());
        responseData.setDesc("Get all successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createRole(@RequestBody RoleDTO role){
        ResponseData responseData = new ResponseData();
        responseData.setData(roleService.add(role));
        responseData.setDesc("Create Role successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateRole(@RequestBody RoleDTO role){
        ResponseData responseData = new ResponseData();
        if (roleService.getById(role.getRoleId()) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Update failed");
            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
        }
        responseData.setData(roleService.update(role));
        responseData.setDesc("Update role successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRole(@RequestParam Integer id){
        ResponseData responseData = new ResponseData();
        if (roleService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Delete failed");

            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
        }
        responseData.setData(roleService.delete(id));
        responseData.setDesc("Delete Role successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}
