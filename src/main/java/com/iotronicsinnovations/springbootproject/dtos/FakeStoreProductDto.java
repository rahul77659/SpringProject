package com.iotronicsinnovations.springbootproject.dtos;

import com.iotronicsinnovations.springbootproject.Models.Category;
import com.iotronicsinnovations.springbootproject.Models.Product;
import com.iotronicsinnovations.springbootproject.Service.ProductService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class FakeStoreProductDto{
    private String title;
    private Long id;
    private String Description;
    private Double price;
    private String image;
    private String category;

    public Product toProduct(){
        Product product = new Product();
        product.setId(getId());
        product.setTitle(getTitle());
        product.setDescription(getDescription());
        product.setPrice(getPrice());
        product.setImageUrl(getImage());
        Category category = new Category();
        category.setTitle(getCategory());
        category.setId(getId());
        product.setCategory(category);
        return product;
    }

}
