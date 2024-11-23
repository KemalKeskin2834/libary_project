package com.kemalkeskin.libary.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kemalkeskin.libary.business.abstracts.BookService;
import com.kemalkeskin.libary.business.Dtos.request.BookRequest;
import com.kemalkeskin.libary.business.Dtos.response.BookResponse;


import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookControllers {

    private BookService bookService;


    @GetMapping("/listbook")
    public ResponseEntity<List<BookResponse>> listbooks(){
        List<BookResponse> bookResponses= bookService.listBook();
        if(bookResponses.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(bookResponses, HttpStatus.OK);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<BookResponse> getById(@PathVariable int id){
        BookResponse bookResponse= bookService.getById(id);
        if(bookResponse==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<BookResponse>(bookResponse,HttpStatus.OK);
    }

    @PostMapping("/addbook")
    public  ResponseEntity<Void> add(@RequestBody BookRequest bookRequest) {
        bookService.add(bookRequest);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/updatebook")
    public  ResponseEntity<Void> update(@RequestParam int id, @RequestBody BookRequest bookRequest) {
        bookService.update(id,bookRequest);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/deletebook/{id}")
    public  ResponseEntity<Void> delete(@PathVariable int id) {
        bookService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    // eğer oturum kimliğine ulaşmak için metotlara  parametre olarak HttpServletResponse vermemiz yeterlidir.
    // sonrada bunu metot içinde çağırarak bulururuz getıd ile onude getsession ile


}
