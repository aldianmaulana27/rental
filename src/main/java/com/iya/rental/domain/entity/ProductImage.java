package com.iya.rental.domain.entity;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "PRODUCT_IMAGE")
@DynamicUpdate
/**
 * create by Aldian July 2022
 */
@Proxy(lazy = false)
@Data 
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImage extends BaseEntity{

    @Column(name = "PRODUCT_UUID", nullable = false)
    private String productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_UUID", insertable = false, updatable = false)
    private Product product;
    
    @Column(name = "IMAGE_UUID", nullable = false)
    private String imageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IMAGE_UUID", insertable = false, updatable = false)
    private Image Image;

}