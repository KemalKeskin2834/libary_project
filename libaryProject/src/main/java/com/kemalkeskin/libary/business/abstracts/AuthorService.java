package com.kemalkeskin.libary.business.abstracts;
import com.kemalkeskin.libary.business.Dtos.request.AuthorRequest;
import com.kemalkeskin.libary.business.Dtos.response.AuthorResponse;
import com.kemalkeskin.libary.entity.Author;

import java.util.List;

public interface AuthorService {

    List<AuthorResponse>listAuthors();

    AuthorResponse getById(int id);

    void add(AuthorRequest authorRequest);

    void update(int id,AuthorRequest authorRequest);

    void delete(int id);

    Author giveMeId(int id);
}
