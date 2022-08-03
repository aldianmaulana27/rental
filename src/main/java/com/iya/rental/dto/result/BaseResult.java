package com.iya.rental.dto.result;

import com.iya.rental.dto.BaseDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseResult extends BaseDTO {

   private static final long serialVersionUID = 691136153913718750L;
   Boolean success = Boolean.TRUE;
   String message;
   Integer code;
}
