package com.kemalkeskin.libary.business.mapper;

import com.kemalkeskin.libary.business.Dtos.response.RentBookResponse;
import com.kemalkeskin.libary.entity.RentBook;

public class RentBookMapper {

    public static RentBookResponse rentBookResponse(RentBook rentBook){

        RentBookResponse rentBookResponse=new RentBookResponse();
        rentBookResponse.setId(rentBook.getId());
        rentBookResponse.setFirstName(rentBook.getFirstName());
        rentBookResponse.setLastName(rentBook.getLastName());
        rentBookResponse.setBookName(rentBook.getBook().getName());
        rentBookResponse.setRentDate(rentBook.getRentDate());
        rentBookResponse.setReturnDate(rentBook.getReturnDate());
        rentBookResponse.setStatus(rentBook.getStatus());
        return  rentBookResponse;
    }

}
