package com.kemalkeskin.libary.controller;

import com.kemalkeskin.libary.business.Dtos.request.CreateRentedBookRequest;
import com.kemalkeskin.libary.business.Dtos.request.UpdateRentBookRequest;
import com.kemalkeskin.libary.business.Dtos.response.PublisherResponse;
import com.kemalkeskin.libary.business.Dtos.response.RentBookResponse;
import com.kemalkeskin.libary.business.abstracts.RentBookService;
import com.kemalkeskin.libary.entity.RentBook;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/rentBooks")
@AllArgsConstructor
public class RentBookControllers {

    private RentBookService rentBookService;

    @GetMapping
    public ResponseEntity<List<RentBookResponse>>listRentedBooks(){
        List<RentBookResponse> rentBookResponse= rentBookService.listRentedBooks();
        return new ResponseEntity<List<RentBookResponse>>(rentBookResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentBookResponse>rentedBookGetById(@PathVariable int id){
        RentBookResponse rentBook=rentBookService.rentedBookGetById(id);
        if(Objects.isNull(rentBook)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(rentBook,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreateRentedBookRequest>rentBook(@RequestBody CreateRentedBookRequest createRentedBookRequest){
       return  new ResponseEntity<>(rentBookService.rentBook(createRentedBookRequest),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UpdateRentBookRequest>  updateRentBook(@RequestParam int id,@RequestBody UpdateRentBookRequest updateRentBookRequest){
        return  new ResponseEntity<>(rentBookService.updateRentBook(id,updateRentBookRequest),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        this.rentBookService.deleteById(id);
    }
}
