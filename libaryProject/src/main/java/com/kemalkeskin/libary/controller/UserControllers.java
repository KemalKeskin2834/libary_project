package com.kemalkeskin.libary.controller;

import com.kemalkeskin.libary.business.Dtos.request.RegisterRequest;
import com.kemalkeskin.libary.business.concretes.UserManager;
import com.kemalkeskin.libary.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class UserControllers {

    //kemal kemal123
    //umut umut123
    private UserManager userManager;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public String register(@RequestBody RegisterRequest registerRequest){
      return userManager.register(registerRequest);
    }



}


