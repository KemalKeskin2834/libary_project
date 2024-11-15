package com.kemalkeskin.libary.business.concretes;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.kemalkeskin.libary.repository.BookRepository;
import org.springframework.stereotype.Service;

import com.kemalkeskin.libary.business.abstracts.AuthorService;
import com.kemalkeskin.libary.business.abstracts.BookService;
import com.kemalkeskin.libary.business.abstracts.BookTypeService;
import com.kemalkeskin.libary.business.abstracts.PublisherService;
import com.kemalkeskin.libary.business.Dtos.request.BookRequest;
import com.kemalkeskin.libary.business.Dtos.response.BookResponse;
import com.kemalkeskin.libary.business.mapper.BookMapper;
import com.kemalkeskin.libary.business.rules.BookBusinessRules;
import com.kemalkeskin.libary.repository.BookRepository;
import com.kemalkeskin.libary.entity.Author;
import com.kemalkeskin.libary.entity.Book;
import com.kemalkeskin.libary.entity.BookType;
import com.kemalkeskin.libary.entity.Publisher;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookManager implements  BookService{

    private BookRepository bookRepository;

    private AuthorService authorService;;

    private PublisherService publisherService;

    private BookTypeService bookTypeService;

    private BookBusinessRules bookBusinessRules;

    @Override
    public List<BookResponse> listBook() {

        List<Book>bookList= bookRepository.findAll();
        return bookList.stream().map(BookMapper::toListBookResponse).collect(Collectors.toList());
    }

    @Override
    public BookResponse getById(int id) {
        this.bookBusinessRules.avaliableId(id);
        return bookRepository.findById(id).map(BookMapper::toBookResponse).get();


    }

    @Override
    public void add(BookRequest bookRequest) {
        this.bookBusinessRules.repeatBookName(bookRequest.getName());
        this.bookBusinessRules.checkIfAuthorId(bookRequest.getAuthorId());
        this.bookBusinessRules.checkIfPublisherId(bookRequest.getPublisherId());
        this.bookBusinessRules.checkIfBookTypeId(bookRequest.getBookTypeId());
        Book book=new Book();
        book.setName(bookRequest.getName());
        book.setPageNumbers(bookRequest.getPageNumbers());
        book.setGiveValue(bookRequest.getGiveValue());

        Author author=authorService.giveMeId(bookRequest.getAuthorId());
        book.setAuthor(author);


        Publisher publisher=publisherService.giveMeId(bookRequest.getPublisherId());
        book.setPublisher(publisher);


        BookType bookType=bookTypeService.giveMeId(bookRequest.getBookTypeId());
        book.setBookType(bookType);

        this.bookRepository.save(book);

    }

    @Override
    public void update(int id, BookRequest bookRequest) {
        this.bookBusinessRules.avaliableId(id);
        this.bookBusinessRules.repeatBookName(bookRequest.getName());
        this.bookBusinessRules.checkIfAuthorId(bookRequest.getAuthorId());
        this.bookBusinessRules.checkIfPublisherId(bookRequest.getPublisherId());
        this.bookBusinessRules.checkIfBookTypeId(bookRequest.getBookTypeId());

        Optional<Book>optional=bookRepository.findById(id);
        Book bookUpdate=optional.get();
        bookUpdate.setName(bookRequest.getName());
        bookUpdate.setPageNumbers(bookRequest.getPageNumbers());


        Author author=authorService.giveMeId(bookRequest.getAuthorId());
        bookUpdate.setAuthor(author);


        Publisher publisher=publisherService.giveMeId(bookRequest.getPublisherId());
        bookUpdate.setPublisher(publisher);


        BookType bookType=bookTypeService.giveMeId(bookRequest.getBookTypeId());
        bookUpdate.setBookType(bookType);

        bookUpdate.setGiveValue(bookRequest.getGiveValue());

        this.bookRepository.save(bookUpdate);


    }

    @Override
    public void delete(int id) {
        this.bookBusinessRules.avaliableId(id);
        this.bookRepository.deleteById(id);

    }

    @Override
    public Book giveMyId(int id) {
        return bookRepository.findById(id).orElseThrow();
    }
}
