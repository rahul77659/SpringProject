package com.iotronicsinnovations.springbootproject.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
  private String title;
  private Double price;
  private String description;
  private String image;
  private String category;
}