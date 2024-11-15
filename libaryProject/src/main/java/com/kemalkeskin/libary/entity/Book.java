package com.kemalkeskin.libary.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "page_numbers")
   // @Min(value = 10 , message = "The book must have at least 10 pages")
    private int pageNumbers;


    @Column(name = "value")
    private int giveValue;   // 1=>available  || 2=> unavailable

    @Transient
    private String status;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "booktype_id")
    private BookType bookType;


    // JPA Lifecycle Callback Anotasyonları=> Veritabanı işlemleri sırasında otomatik işlemler yapmak için.
    @PostLoad //Veritabanından bir entity yüklendikten hemen sonra çağrılır.
    @PreUpdate //Entity güncellenmeden hemen önce çağrılır.
    private void updateStatus() {
      //  this.status = (giveValue == 2) ? "Mevcut" : "Mevcut Değil";
        if(giveValue==1){
            this.status="mevcut";
        }else{
            this.status="mevcut değil";
        }

    }
}
