package com.kemalkeskin.libary.business.Dtos.request;

import java.time.LocalDate;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateRentedBookRequest {

    private String firstName;
    private String lastName;
    private LocalDate rentDate;
    private int bookId;
    private int giveValue;
}
