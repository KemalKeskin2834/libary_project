package com.kemalkeskin.libary.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kemalkeskin.libary.business.abstracts.AuthorService;
import com.kemalkeskin.libary.business.Dtos.request.AuthorRequest;
import com.kemalkeskin.libary.business.Dtos.response.AuthorResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/authors")
@AllArgsConstructor
public class AuthorControllers {

    private AuthorService authorService;


    @GetMapping("/listauthor")
    public ResponseEntity<List<AuthorResponse>> listAuthors(){
        List<AuthorResponse> authorResponse= authorService.listAuthors();
        return new ResponseEntity<List<AuthorResponse>>(authorResponse, HttpStatus.OK);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<AuthorResponse> getById(@PathVariable int id){
        AuthorResponse authorResponse= authorService.getById(id);
        if(authorResponse==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<AuthorResponse>(authorResponse,HttpStatus.OK);
    }

    @PostMapping("/addauthor")
    public  ResponseEntity<Void> add(@RequestBody AuthorRequest authorRequest) {
        authorService.add(authorRequest);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/updateauthor")
    public  ResponseEntity<Void> update(@RequestParam int id, @RequestBody AuthorRequest updateAuthorRequest) {
        authorService.update(id,updateAuthorRequest);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteauthor/{id}")
    public  ResponseEntity<Void> delete(@PathVariable int id) {
        authorService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
