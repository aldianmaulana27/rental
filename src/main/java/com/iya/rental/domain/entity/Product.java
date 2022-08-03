package com.iya.rental.domain.entity;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "PRODUCT")
@DynamicUpdate
/**
 * create by Aldian July 2022
 */
@Proxy(lazy = false)
@Data 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity{

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "YEAR",  nullable = false)
    private Integer year;

    @Column(name = "COLOR", nullable = false)
    private String color;

    @Column(name = "CAPACITY", nullable = false)
    private Integer capacity;
        
    @Column(name = "GAS")
    private String gas;

    @Column(name = "TRANSMISSION", nullable = false)
    private String transmission;

    @Column(name = "WEEKDAY_PRICE", nullable = false)
    private String weekdayPrice;

    @Column(name = "WEEKEND_PRICE", nullable = false)
    private String weekendPrice;

    @Column(name = "IMAGE_UUID", nullable = false)
    private String imageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IMAGE_UUID", insertable = false, updatable = false)
    private Image image;
   

}