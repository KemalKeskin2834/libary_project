package com.kemalkeskin.libary.business.rules;
import com.kemalkeskin.libary.core.exception.BusinessException;
import com.kemalkeskin.libary.repository.AuthorRepository;
import com.kemalkeskin.libary.repository.BookRepository;
import com.kemalkeskin.libary.repository.BookTypeRepository;
import com.kemalkeskin.libary.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BookBusinessRules {
    private BookRepository bookRepository;

    private AuthorRepository authorRepository;

    private BookTypeRepository bookTypeRepository;

    private PublisherRepository publisherRepository;


    public void repeatBookName(String name) {
        if(bookRepository.existsByName(name)) {
            throw new BusinessException(" Book name avaliable");
        }
    }


    public void avaliableId(int id) {
        if(!bookRepository.findById(id).isPresent()) {
            throw new BusinessException(" don't found id");
        }
    }

    public void checkIfAuthorId(int id) {
        if(!authorRepository.findById(id).isPresent()) {
            throw new BusinessException(" don't avaliable  author ");
        }
    }

    public void checkIfPublisherId(int id) {
        if(!publisherRepository.findById(id).isPresent()) {
            throw new BusinessException(" don't avaliable  publisher ");
        }
    }

    public void checkIfBookTypeId(int id) {
        if(!bookTypeRepository.findById(id).isPresent()) {
            throw new BusinessException(" don't avaliable  book type ");
        }
    }
}
