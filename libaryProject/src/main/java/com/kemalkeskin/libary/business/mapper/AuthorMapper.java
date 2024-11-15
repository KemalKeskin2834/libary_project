package com.kemalkeskin.libary.business.mapper;

import com.kemalkeskin.libary.business.Dtos.response.AuthorResponse;
import com.kemalkeskin.libary.entity.Author;

public class AuthorMapper {


    public static AuthorResponse toAuthorListResponse(Author author) {

        AuthorResponse authorResponses=new AuthorResponse();
        authorResponses.setId(author.getId());
        authorResponses.setName(author.getName());
        return authorResponses;
    }

    public static AuthorResponse toAuthorResponse(Author author) {

        AuthorResponse authorResponses=new AuthorResponse();
        authorResponses.setId(author.getId());
        authorResponses.setName(author.getName());
        return authorResponses;
    }
}
