package com.kemalkeskin.libary.business.Dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookResponse {

    private int id;

    private String name;

    private int pageNumbers;

    private String status;

    private String authorName;

    private String publisherName;

    private String bookType;



}
