package com.iotronicsinnovations.springbootproject.Controllers;

import com.iotronicsinnovations.springbootproject.Models.Product;
import com.iotronicsinnovations.springbootproject.Service.ProductService;
import com.iotronicsinnovations.springbootproject.dtos.CreateProductRequestDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto productRequestDto){
        return productService.createProduct(
                productRequestDto.getTitle(),
                productRequestDto.getDescription(),
                productRequestDto.getImage(),
                productRequestDto.getCategory(),
                productRequestDto.getPrice()
        );
    }
//ResponseEntity
@GetMapping("/products")
public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> responseData = productService.getAllProducts();

        ResponseEntity<List<Product>> responseEntity =
                new ResponseEntity<>(responseData,
                        HttpStatusCode.valueOf(205));


//        throw new RuntimeException();   // to Cheek 500 Status Code
    return responseEntity;
    //        return ("From products Controllers We are going to display all products");
}
@GetMapping("/products/{id1}")
public Product getSingleProduct(@PathVariable("id1") Long id){
    return productService.getSingleProduct(id);
}

}



