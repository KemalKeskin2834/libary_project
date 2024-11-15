package com.kemalkeskin.libary.business.rules;
import com.kemalkeskin.libary.core.exception.BusinessException;
import com.kemalkeskin.libary.repository.BookTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BookTypeBusinessRules {

    private BookTypeRepository bookTypeRepository;

    public void repeatBookType(String type) {
        if(bookTypeRepository.existsByType(type)) {
            throw new BusinessException(" Book type avaliable");
        }
    }


    public void avaliableId(int id) {
        if(!bookTypeRepository.findById(id).isPresent()) {
            throw new BusinessException(" don't found id");
        }
    }
}
