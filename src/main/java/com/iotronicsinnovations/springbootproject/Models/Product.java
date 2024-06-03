package com.iotronicsinnovations.springbootproject.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter   //Lombok Provide these getter setter Annotation
public class Product {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private Category category;
    private String productSKU; // this is different from DTO

}
