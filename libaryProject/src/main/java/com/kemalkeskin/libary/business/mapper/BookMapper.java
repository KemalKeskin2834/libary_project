package com.kemalkeskin.libary.business.mapper;

import com.kemalkeskin.libary.business.Dtos.response.BookResponse;
import com.kemalkeskin.libary.entity.Book;

public class BookMapper {

    public static BookResponse toListBookResponse(Book book) {
        BookResponse bookResponse=new BookResponse();
        bookResponse.setId(book.getId());
        bookResponse.setName(book.getName());
        bookResponse.setPageNumbers(book.getPageNumbers());
        bookResponse.setStatus(book.getStatus());
        bookResponse.setAuthorName(book.getAuthor().getName());
        bookResponse.setBookType(book.getBookType().getType());
        bookResponse.setPublisherName(book.getPublisher().getName());


        return bookResponse;
    }

    public static BookResponse toBookResponse(Book book) {
        BookResponse bookResponse=new BookResponse();
        bookResponse.setId(book.getId());
        bookResponse.setName(book.getName());
        bookResponse.setPageNumbers(book.getPageNumbers());
        bookResponse.setStatus(book.getStatus());
        bookResponse.setPublisherName(book.getPublisher().getName());
        bookResponse.setAuthorName(book.getAuthor().getName());
        bookResponse.setBookType(book.getBookType().getType());
        return bookResponse;
    }
}
