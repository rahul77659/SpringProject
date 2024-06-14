package com.iotronicsinnovations.springbootproject.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter   //Lombok Provide these getter setter Annotation
@Entity
public class Product extends BaseModel {
//    private Long id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;


    private String productSKU; // this is different from DTO
//    private Category category;

    //cardinality between Product Category

    @ManyToOne
    private Category category;
}
