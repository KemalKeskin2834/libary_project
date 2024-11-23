package com.kemalkeskin.libary.business.concretes;

import com.kemalkeskin.libary.business.Dtos.request.RegisterRequest;
import com.kemalkeskin.libary.entity.User;
import com.kemalkeskin.libary.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class UserManager  {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;


    //private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    // strength şifreyi hashlerken kaç tur döneceğini belirtir yani 12 tur döner
    // formulude 2^n n=> sayısı veriğimiz sayıdır
    // 12  verdiğimizde 4096 tur işlem yapılır
    // idelai 10 dur ama şunu unutmamak lazım sayıyı ne kadar yüksek verirsen
    // çözülmesi zorlaşır ama sistem yavaşlar çünkü tur sayısı yükselir



    public String register(RegisterRequest RegisterRequest) {

        User user=new User();
        user.setUserName(RegisterRequest.getUserName());
        user.setPassword(passwordEncoder.encode(RegisterRequest.getPassword()));
        userRepository.save(user);
         return  "kayıt olundu";
    }




}
