package com.kemalkeskin.libary.repository;

import com.kemalkeskin.libary.entity.RentBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentBookRepository extends JpaRepository<RentBook,Integer> {
}
