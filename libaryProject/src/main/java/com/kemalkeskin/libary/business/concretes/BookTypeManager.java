package com.kemalkeskin.libary.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kemalkeskin.libary.business.abstracts.BookTypeService;
import com.kemalkeskin.libary.business.Dtos.request.BookTypeRequest;
import com.kemalkeskin.libary.business.Dtos.response.BookTypeResponse;
import com.kemalkeskin.libary.business.mapper.BookTypeMapper;
import com.kemalkeskin.libary.business.rules.BookTypeBusinessRules;
import com.kemalkeskin.libary.repository.BookTypeRepository;
import com.kemalkeskin.libary.entity.BookType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookTypeManager implements  BookTypeService {

    private BookTypeRepository bookTypeRepository;

    private BookTypeBusinessRules bookTypeBusinessRules;

    @Override
    public List<BookTypeResponse> listBookType() {

        return bookTypeRepository.findAll().stream().map(BookTypeMapper::toListBookTypeResponse).collect(Collectors.toList());
    }

    @Override
    public BookTypeResponse getById(int id) {
        this.bookTypeBusinessRules.avaliableId(id);
        return bookTypeRepository.findById(id).map(BookTypeMapper::toBookTypeResponse).get();


    }

    @Override
    public void add(BookTypeRequest bookTypeRequest) {
        this.bookTypeBusinessRules.repeatBookType(bookTypeRequest.getType());
        BookType bookType=new BookType();
        bookType.setType(bookTypeRequest.getType());
        this.bookTypeRepository.save(bookType);


    }

    @Override
    public void update(int id, BookTypeRequest bookTypeRequest) {
        this.bookTypeBusinessRules.avaliableId(id);
        this.bookTypeBusinessRules.repeatBookType(bookTypeRequest.getType());
        Optional<BookType>optional=this.bookTypeRepository.findById(id);
        BookType bookType=optional.get();
        bookType.setType(bookTypeRequest.getType());
        bookTypeRepository.save(bookType);


    }

    @Override
    public void delete(int id) {
        this.bookTypeBusinessRules.avaliableId(id);
        this.bookTypeRepository.deleteById(id);

    }

    @Override
    public BookType giveMeId(int id) {
        this.bookTypeBusinessRules.avaliableId(id);
        return bookTypeRepository.findById(id).orElse(null);
    }
}
