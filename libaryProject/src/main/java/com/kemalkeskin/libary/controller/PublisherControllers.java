package com.kemalkeskin.libary.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kemalkeskin.libary.business.abstracts.PublisherService;
import com.kemalkeskin.libary.business.Dtos.request.PublisherRequest;
import com.kemalkeskin.libary.business.Dtos.response.PublisherResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/publishers")
@AllArgsConstructor
public class PublisherControllers {

    private PublisherService publisherService;


    @GetMapping("/listpublisher")
    public ResponseEntity<List<PublisherResponse>> listAuthors(){
        List<PublisherResponse> publisherResponses= publisherService.listPublisher();
        return new ResponseEntity<List<PublisherResponse>>(publisherResponses, HttpStatus.OK);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<PublisherResponse> getById(@PathVariable int id){
        PublisherResponse publisherResponse= publisherService.getById(id);
        if(publisherResponse==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<PublisherResponse>(publisherResponse,HttpStatus.OK);
    }

    @PostMapping("/addpublisher")
    public  ResponseEntity<Void> add(@RequestBody PublisherRequest publisherRequest) {
        publisherService.add(publisherRequest);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/updatepublisher")
    public  ResponseEntity<Void> update(@RequestParam int id, @RequestBody PublisherRequest publisherRequest) {
        publisherService.update(id,publisherRequest);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/deletepublisher/{id}")
    public  ResponseEntity<Void> delete(@PathVariable int id) {
        publisherService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
