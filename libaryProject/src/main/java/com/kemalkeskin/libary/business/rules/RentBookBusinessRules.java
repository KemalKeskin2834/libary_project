package com.kemalkeskin.libary.business.rules;

import com.kemalkeskin.libary.core.exception.BusinessException;
import com.kemalkeskin.libary.repository.RentBookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RentBookBusinessRules {

    private RentBookRepository rentBookRepository;


    public void getFoundId(int id){
        if(!rentBookRepository.findById(id).isPresent()){
            throw new BusinessException("don't found id = "+id);
        }
    }
}
