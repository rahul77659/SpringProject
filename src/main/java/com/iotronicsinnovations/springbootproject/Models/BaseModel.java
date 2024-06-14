package com.iotronicsinnovations.springbootproject.Models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass // to handle inheritance in DB
public class BaseModel {
    @Id
  private  Long id;
   private Date CreatedAT;
   private Date updatedAt;
   private int isDeleted;
    @Transient
    private String createdBy;
}

