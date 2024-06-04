package com.iotronicsinnovations.springbootproject.Controllers;

import com.iotronicsinnovations.springbootproject.Models.Product;
import com.iotronicsinnovations.springbootproject.Service.FakeStoreProductService;
import com.iotronicsinnovations.springbootproject.Service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class productController {
    ///Instead of this use dependency Injection that is mak a constructor
    // ProductService productService=new FakeStoreProductService();
    ////Dependency injection i.e. Let Spring creates teh object and passes
    ProductService productService;
    public productController (ProductService productService)
    {
        this.productService = productService;
    }
    @GetMapping("/products")
    public void getAllProducts() {
        //        return ("From products Controllers We are going to display all products");
    }
    @GetMapping("/products/{id1}")
    public Product getSingleProduct(@PathVariable("id1") Long id){
        return productService.getSingleProduct(id);
    }
}



