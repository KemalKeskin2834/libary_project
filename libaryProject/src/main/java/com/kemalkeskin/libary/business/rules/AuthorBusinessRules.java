package com.kemalkeskin.libary.business.rules;

import com.kemalkeskin.libary.core.exception.BusinessException;
import com.kemalkeskin.libary.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthorBusinessRules {

    private AuthorRepository authorRepository;


    public void repeatAuthorName(String name) {
        if(authorRepository.existsByName(name)) {
            throw new BusinessException(" author name avaliable");
        }
    }


    public void avaliableId(int id) {
        if(!authorRepository.findById(id).isPresent()) {
            throw new BusinessException(" don't found id");
        }
    }
}
