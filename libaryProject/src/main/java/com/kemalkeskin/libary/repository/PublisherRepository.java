package com.kemalkeskin.libary.repository;


import com.kemalkeskin.libary.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Integer> {

    boolean existsByName(String name);
}
