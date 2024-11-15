package com.kemalkeskin.libary.business.Dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RentBookResponse {

    private int id;
    private String firstName;
    private String lastName;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private String bookName;
    private  String status;
}
