package com.iya.rental.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.iya.rental.domain.entity.BaseEntity;


@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, String>{
   
    T findByUuid(String uuid);
    
}