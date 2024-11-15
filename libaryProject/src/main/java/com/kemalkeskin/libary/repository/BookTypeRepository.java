package com.kemalkeskin.libary.repository;

import com.kemalkeskin.libary.entity.BookType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookTypeRepository extends JpaRepository<BookType,Integer> {

    boolean existsByType(String type);
}
