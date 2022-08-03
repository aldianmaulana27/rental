package com.iya.rental.domain.entity;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import lombok.Data;



@Entity
@Table(name = "USER")
@DynamicUpdate
/**
 * create by Aldian July 2022
 */
@Proxy(lazy = false)
@Data 
public class User extends BaseEntity{

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PASSWORD", unique = true, nullable = false)
    private String password;

    @Column(name = "PHONE", nullable = false)
    private String phone;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;
        
    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "ROLE_UUID", nullable = false)
    private String role_uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_UUID", insertable = false, updatable = false)
    private Role role;
   

}