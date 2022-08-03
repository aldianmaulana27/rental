package com.iya.rental.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iya.rental.domain.entity.Product;


@Repository
public interface ProductRepository extends BaseRepository<Product> {
   
    Product findByUuid(String uuid);
    Product findByName(String name);

    List<Product> findByIsDeleteIsNullOrderByCreationDateDesc();
    
}