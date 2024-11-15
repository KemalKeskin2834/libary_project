package com.kemalkeskin.libary.business.rules;
import com.kemalkeskin.libary.core.exception.BusinessException;
import com.kemalkeskin.libary.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PublisherBusinessRules {

    private PublisherRepository publisherRepository;

    public void repeatPublisherName(String name) {
        if(publisherRepository.existsByName(name)) {
            throw new BusinessException(" publisher name avaliable");
        }
    }


    public void avaliableId(int id) {
        if(!publisherRepository.findById(id).isPresent()) {
            throw new BusinessException(" don't found id");
        }
    }
}
