package com.kemalkeskin.libary.business.abstracts;

import com.kemalkeskin.libary.business.Dtos.request.BookTypeRequest;
import com.kemalkeskin.libary.business.Dtos.response.BookTypeResponse;
import com.kemalkeskin.libary.entity.BookType;

import java.util.List;

public interface BookTypeService {

    List<BookTypeResponse> listBookType();

    BookTypeResponse getById(int id);

    void add(BookTypeRequest bookTypeRequest);

    void update(int id,BookTypeRequest bookTypeRequest);

    void delete(int id);

    BookType giveMeId(int id);
}
