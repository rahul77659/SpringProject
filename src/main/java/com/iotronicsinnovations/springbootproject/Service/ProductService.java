package com.iotronicsinnovations.springbootproject.Service;

import com.iotronicsinnovations.springbootproject.Models.Product;
import com.iotronicsinnovations.springbootproject.dtos.CreateProductRequestDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
public interface ProductService <T>{
    public Product getSingleProduct(Long id);
//  public Product CreateProduct(CreateProductRequestDto createProductRequestDto);
//  To make create Product mre General use below
//    public Product createProduct(String title,String Description,String ImageUrl,String Category,double price);

    public Product createProduct(String title, String description, String image, String category, double price);

    public List<Product> getAllProducts();
//    Product createProduct();
}
