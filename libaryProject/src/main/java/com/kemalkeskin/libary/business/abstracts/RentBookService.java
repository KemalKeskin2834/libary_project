package com.kemalkeskin.libary.business.abstracts;

import com.kemalkeskin.libary.business.Dtos.request.CreateRentedBookRequest;
import com.kemalkeskin.libary.business.Dtos.request.UpdateRentBookRequest;
import com.kemalkeskin.libary.business.Dtos.response.RentBookResponse;
import com.kemalkeskin.libary.entity.Author;
import com.kemalkeskin.libary.entity.RentBook;

import java.util.List;

public interface RentBookService {

    List<RentBookResponse>listRentedBooks();

    RentBookResponse rentedBookGetById(int id);

    CreateRentedBookRequest rentBook(CreateRentedBookRequest createRentedBookRequest);

    UpdateRentBookRequest updateRentBook(int id,UpdateRentBookRequest updateRentBookRequest);

    void deleteById(int id);





}
