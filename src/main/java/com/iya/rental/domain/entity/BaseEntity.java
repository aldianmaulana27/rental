package com.iya.rental.domain.entity;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data 
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -7369920601847524273L;

    public BaseEntity(){ }

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "UUID", unique = true)
    private String uuid;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_CREATED", updatable = false, nullable = false)
    private Date creationDate;

    @CreatedBy
    @Column(name = "CREATED_BY", length = 50, updatable = false)
    private String CreatedBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_MODIFIED")
    private Date modificationDate;
 
    @LastModifiedBy
    @Column(name = "MODIFIED_BY", length = 50)
    private String modifiedBy;
    @Column(name = "IS_DELETE", nullable = true)
    private Date isDelete;

    @PrePersist
    public void prePersist() {

        this.uuid = UUID.randomUUID().toString();
        this.creationDate = new Date();
    }

    @PreUpdate
    public void preUpdate(){this.modificationDate = new Date();
    }
}



