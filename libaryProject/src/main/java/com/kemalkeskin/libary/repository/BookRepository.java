package com.kemalkeskin.libary.repository;

import com.kemalkeskin.libary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    boolean existsByName(String name);

    @Query("SELECT b.giveValue FROM Book b WHERE b.id = :id")
    Book findByGiveValue(@Param("id")int id);
}
