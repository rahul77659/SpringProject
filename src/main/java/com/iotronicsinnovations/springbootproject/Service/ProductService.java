package com.iotronicsinnovations.springbootproject.Service;

import com.iotronicsinnovations.springbootproject.Models.Product;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public interface ProductService {
    public Product getSingleProduct(Long id);

}
