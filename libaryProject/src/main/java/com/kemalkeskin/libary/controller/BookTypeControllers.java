package com.kemalkeskin.libary.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kemalkeskin.libary.business.abstracts.BookTypeService;
import com.kemalkeskin.libary.business.Dtos.request.BookTypeRequest;
import com.kemalkeskin.libary.business.Dtos.response.BookTypeResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/booktypes")
@AllArgsConstructor
public class BookTypeControllers {

    private BookTypeService bookTypeService;

    @GetMapping("/listbooktype")
    public ResponseEntity<List<BookTypeResponse>> listAuthors(){
        List<BookTypeResponse> bookTypeResponse= bookTypeService.listBookType();
        return new ResponseEntity<List<BookTypeResponse>>(bookTypeResponse, HttpStatus.OK);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<BookTypeResponse> getById(@PathVariable int id){
        BookTypeResponse bookTypeResponse= bookTypeService.getById(id);
        if(bookTypeResponse==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<BookTypeResponse>(bookTypeResponse,HttpStatus.OK);
    }

    @PostMapping("/addbooktype")
    public  ResponseEntity<Void> add(@RequestBody BookTypeRequest bookTypeRequest) {
        bookTypeService.add(bookTypeRequest);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/updatebooktype")
    public  ResponseEntity<Void> update(@RequestParam int id, @RequestBody BookTypeRequest bookTypeRequest) {
        bookTypeService.update(id,bookTypeRequest);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/deletebooktype/{id}")
    public  ResponseEntity<Void> delete(@PathVariable int id) {
        bookTypeService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
