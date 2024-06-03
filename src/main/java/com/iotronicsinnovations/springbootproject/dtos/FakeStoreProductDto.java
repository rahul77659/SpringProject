package com.iotronicsinnovations.springbootproject.dtos;

import com.iotronicsinnovations.springbootproject.Models.Category;
import com.iotronicsinnovations.springbootproject.Service.ProductService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class FakeStoreProductDto{
    private String title;
    private Long id;
    private String description;
    private Double price;
    private String image;
    private String category;

}
