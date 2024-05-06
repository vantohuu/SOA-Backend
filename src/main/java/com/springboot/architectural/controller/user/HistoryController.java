package com.springboot.architectural.controller.user;

import com.springboot.architectural.dto.CountryDTO;
import com.springboot.architectural.dto.HistoryDTO;
import com.springboot.architectural.payload.ResponseData;
import com.springboot.architectural.service.CountryService;
import com.springboot.architectural.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/history")
public class HistoryController {
    @Autowired
    HistoryService historyService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable(name = "id") Integer id){
        ResponseData responseData = new ResponseData();
        if (historyService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Not found history By ID");
            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
        }
        responseData.setData(historyService.getById(id));
        responseData.setDesc("Get history successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllRole(){
        ResponseData responseData = new ResponseData();
        responseData.setData(historyService.getAll());
        responseData.setDesc("Get all successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody HistoryDTO historyDTO){
        ResponseData responseData = new ResponseData();
        responseData.setData(historyService.add(historyDTO));
        responseData.setDesc("Create history successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody HistoryDTO historyDTO){
        ResponseData responseData = new ResponseData();
        if (historyService.getById(historyDTO.getId()) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Update failed");
            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
        }
        responseData.setData(historyService.update(historyDTO));
        responseData.setDesc("Update history successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Integer id){
        ResponseData responseData = new ResponseData();
        if (historyService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Delete failed");

            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
        }
        responseData.setData(historyService.delete(id));
        responseData.setDesc("Delete history successfully");
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
