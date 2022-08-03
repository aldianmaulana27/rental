package com.iya.rental.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iya.rental.domain.entity.ProductImage;

@Repository
public interface ProductImageRepository extends BaseRepository<ProductImage> {
   
    List<ProductImage> findByProductId(String uuid);

    
}