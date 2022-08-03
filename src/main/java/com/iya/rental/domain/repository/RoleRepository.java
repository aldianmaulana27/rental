package com.iya.rental.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iya.rental.domain.entity.Role;


@Repository
public interface RoleRepository extends BaseRepository<Role> {
   
    Role findByUuid(String uuid);
    Role findByName(String name);
    List<Role> findByIsDeleteIsNull();
    
}