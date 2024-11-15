package com.kemalkeskin.libary.business.mapper;

import com.kemalkeskin.libary.business.Dtos.response.BookTypeResponse;
import com.kemalkeskin.libary.entity.BookType;

public class BookTypeMapper {
    public static BookTypeResponse toListBookTypeResponse(BookType bookType){
        BookTypeResponse bookTypeResponse=new BookTypeResponse();
        bookTypeResponse.setId(bookType.getId());
        bookTypeResponse.setType(bookType.getType());
        return bookTypeResponse;
    }

    public static BookTypeResponse toBookTypeResponse(BookType bookType){
        BookTypeResponse bookTypeResponse=new BookTypeResponse();
        bookTypeResponse.setId(bookType.getId());
        bookTypeResponse.setType(bookType.getType());
        return bookTypeResponse;
    }
}
