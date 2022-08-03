package com.iya.rental.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iya.rental.domain.entity.Image;

@Repository
public interface ImageRepository extends BaseRepository<Image> {
    Image findByName(String name);
    Image findByNameAndCategory(String name, String category);
    List<Image> findByCategory(String category);
    List<Image> findByIsDeleteIsNull();   
}