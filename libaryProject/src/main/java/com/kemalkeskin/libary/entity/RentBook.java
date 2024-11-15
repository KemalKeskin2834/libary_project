package com.kemalkeskin.libary.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "rentbooks")
public class RentBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "give_value")
    private int giveValue;

    @Transient// veri tabanına kayıt olmaz sutun olarak olmaz
    private  String status;

    @Column(name = "rent_date")
    private LocalDate rentDate;

    @Column(name = "return_date")
    private LocalDate returnDate=null;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public String getStatus() {

        if(returnDate==null){
            return "teslim edilmedi" ;
        }else{
            return "teslim edildi";
        }

    }
}
