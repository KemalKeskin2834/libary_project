package com.kemalkeskin.libary.repository;

import com.kemalkeskin.libary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByUserName(String userName);
    Optional<User>findByUserName(String userName);
}
