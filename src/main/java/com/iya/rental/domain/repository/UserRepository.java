package com.iya.rental.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iya.rental.domain.entity.User;


@Repository
public interface UserRepository extends BaseRepository<User> {
   
    User findByUuid(String uuid);
    User findByName(String name);
    User findByEmail(String email);

    List<User> findByIsDeleteIsNullOrderByCreationDateDesc();
    
}