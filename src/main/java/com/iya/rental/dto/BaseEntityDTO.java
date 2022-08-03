package com.iya.rental.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseEntityDTO extends BaseDTO {

   private static final long serialVersionUID = -5717115331592213054L;

   private String id;

   private String createdBy;

   private Date dateCreated;

   private String modifiedBy;

   private Date dateModified;

   private String deletedBy;

   private Date dateDeleted;

}
