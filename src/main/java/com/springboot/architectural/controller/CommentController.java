package com.springboot.architectural.controller;

import com.springboot.architectural.dto.CommentDTO;
import com.springboot.architectural.dto.HistoryDTO;
import com.springboot.architectural.payload.ResponseData;
import com.springboot.architectural.service.CommentService;
import com.springboot.architectural.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable(name = "id") Integer id){
        ResponseData responseData = new ResponseData();
        if (commentService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Not found comment By ID");
            return new ResponseEntity<>(responseData.getData(), HttpStatus.NOT_FOUND);
        }
        responseData.setData(commentService.getById(id));
        responseData.setDesc("Get comment successfully");
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllRole(){
        ResponseData responseData = new ResponseData();
        responseData.setData(commentService.getAll());
        responseData.setDesc("Get all successfully");
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }

    @GetMapping("/get-page-by-movie")
    public ResponseEntity<?> getPageCommentByMovie(@RequestParam(defaultValue = "0") Integer offset,
                                                    @RequestParam(defaultValue = "0") Integer pageSize,
                                                    @RequestParam(defaultValue = "idComment") String field,
                                                    @RequestParam(defaultValue = "") String searchContent,
                                                    @RequestParam(defaultValue = "") Integer movieId) {
        ResponseData responseData = new ResponseData();
        responseData.setData(commentService.findByMovieWithPaginationAndSorting(searchContent,movieId,offset,pageSize, field));
        responseData.setSuccess(true);
        responseData.setDesc("Get success");
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CommentDTO commentDTO){
        ResponseData responseData = new ResponseData();
        responseData.setData(commentService.add(commentDTO));
        responseData.setDesc("Create comment successfully");
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody CommentDTO commentDTO){
        ResponseData responseData = new ResponseData();
        if (commentService.getById(commentDTO.getIdComment()) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Update failed");
            return new ResponseEntity<>(responseData.getData(), HttpStatus.NOT_FOUND);
        }
        responseData.setData(commentService.update(commentDTO));
        responseData.setDesc("Update comment successfully");
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Integer id){
        ResponseData responseData = new ResponseData();
        if (commentService.getById(id) == null)
        {
            responseData.setSuccess(false);
            responseData.setDesc("Delete failed");

            return new ResponseEntity<>(responseData.getData(), HttpStatus.NOT_FOUND);
        }
        responseData.setData(commentService.delete(id));
        responseData.setDesc("Delete comment successfully");
        return new ResponseEntity<>(responseData.getData(), HttpStatus.OK);
    }



}
