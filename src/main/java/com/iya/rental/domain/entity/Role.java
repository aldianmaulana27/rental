package com.iya.rental.domain.entity;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import lombok.Data;



@Entity
@Table(name = "Role")
@DynamicUpdate
/**
 * create by Aldian July 2022
 */
@Proxy(lazy = false)
@Data 
public class Role extends BaseEntity{

    @Column(name = "NAME", nullable = false)
    private String name;    

}