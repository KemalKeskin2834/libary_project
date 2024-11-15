package com.kemalkeskin.libary.business.Dtos.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookRequest {

    private String name;


    private int pageNumbers;

    private  int giveValue;


    private int authorId;


    private int publisherId;


    private int bookTypeId;

}
