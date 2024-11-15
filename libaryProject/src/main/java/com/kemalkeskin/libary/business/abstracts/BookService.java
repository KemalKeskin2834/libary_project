package com.kemalkeskin.libary.business.abstracts;

import com.kemalkeskin.libary.business.Dtos.request.BookRequest;
import com.kemalkeskin.libary.business.Dtos.response.BookResponse;
import com.kemalkeskin.libary.entity.Book;

import java.util.List;

public interface BookService {

    List<BookResponse> listBook();

    BookResponse getById(int id);

    void add(BookRequest bookRequest);

    void update(int id,BookRequest bookRequest);

    void delete(int id);

    Book giveMyId(int id);
}
