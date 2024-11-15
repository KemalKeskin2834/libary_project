package com.kemalkeskin.libary.business.concretes;

import com.kemalkeskin.libary.business.Dtos.request.CreateRentedBookRequest;
import com.kemalkeskin.libary.business.Dtos.request.UpdateRentBookRequest;
import com.kemalkeskin.libary.business.Dtos.response.RentBookResponse;
import com.kemalkeskin.libary.business.abstracts.BookService;
import com.kemalkeskin.libary.business.abstracts.RentBookService;
import com.kemalkeskin.libary.business.mapper.RentBookMapper;
import com.kemalkeskin.libary.business.rules.RentBookBusinessRules;
import com.kemalkeskin.libary.core.exception.BusinessException;
import com.kemalkeskin.libary.entity.Book;
import com.kemalkeskin.libary.entity.RentBook;
import com.kemalkeskin.libary.repository.BookRepository;
import com.kemalkeskin.libary.repository.RentBookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentBookManager implements RentBookService {

    private  RentBookRepository rentBookRepository;
    private RentBookBusinessRules rentBookBusinessRules;
    private BookService bookService;
    private BookRepository bookRepository;

    @Override
    public List<RentBookResponse> listRentedBooks() {
        List<RentBook>rentBooks=rentBookRepository.findAll();
        List<RentBookResponse>rentBookResponses=rentBooks.stream().map(RentBookMapper::rentBookResponse).collect(Collectors.toList());
        return rentBookResponses;
    }

    @Override
    public RentBookResponse rentedBookGetById(int id) {
        rentBookBusinessRules.getFoundId(id);
        return rentBookRepository.findById(id).map(RentBookMapper::rentBookResponse).get();
    }

    @Override
    public CreateRentedBookRequest rentBook(CreateRentedBookRequest createRentedBookRequest) {

        RentBook rentBook=new RentBook();
        rentBook.setFirstName(createRentedBookRequest.getFirstName());
        rentBook.setLastName(createRentedBookRequest.getLastName());
        rentBook.setRentDate(createRentedBookRequest.getRentDate());
        Book giveId=bookService.giveMyId(createRentedBookRequest.getBookId());
        rentBook.setBook(giveId);
        rentBook.setGiveValue(1);
        RentBook rentBook1= rentBookRepository.save(rentBook);
        Book book=bookRepository.findById(createRentedBookRequest.getBookId()).orElseThrow(() -> new BusinessException("nonavaliable book"));
        book.setGiveValue(createRentedBookRequest.getGiveValue());
        bookRepository.save(book);
        return createRentedBookRequest;
    }

    @Override
    public UpdateRentBookRequest updateRentBook(int id, UpdateRentBookRequest updateRentBookRequest) {
        rentBookBusinessRules.getFoundId(id);
        RentBook rentBookUpdate=rentBookRepository.findById(id).get();
        rentBookUpdate.setFirstName(updateRentBookRequest.getFirstName());
        rentBookUpdate.setLastName(updateRentBookRequest.getLastName());
        rentBookUpdate.setRentDate(updateRentBookRequest.getRentDate());
        rentBookUpdate.setReturnDate(updateRentBookRequest.getReturnDate());
        Book giveId=bookService.giveMyId(updateRentBookRequest.getBookId());
        rentBookUpdate.setBook(giveId);
        rentBookUpdate.setGiveValue(updateRentBookRequest.getGiveValue());
        RentBook rentBook1= rentBookRepository.save(rentBookUpdate);

        Book book=bookRepository.findById(updateRentBookRequest.getBookId()).orElseThrow(() -> new BusinessException("nonavaliable book"));
        book.setGiveValue(updateRentBookRequest.getGiveValue());
        bookRepository.save(book);
        return updateRentBookRequest;
    }

    @Override
    public void deleteById(int id) {
        this.rentBookBusinessRules.getFoundId(id);
        this.rentBookRepository.deleteById(id);
    }


}
