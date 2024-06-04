package com.iotronicsinnovations.springbootproject.Service;

import com.iotronicsinnovations.springbootproject.Models.Category;
import com.iotronicsinnovations.springbootproject.Models.Product;
import com.iotronicsinnovations.springbootproject.dtos.FakeStoreProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//@Component
  //@Service//Use any component  or service
public class FakeStoreProductService implements ProductService
{
    RestTemplate restTemplate;

    //Spring will look inside to check whether it has spring object

    public FakeStoreProductService (RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    @Override
    public Product getSingleProduct(Long id){

//        Instead of writing Resttemplate here we will use it through Beans
//        RestTemplate restTemplate = new RestTemplate();
        //RestTemplate restTemplate;
        FakeStoreProductDto fakeStoreProductDto= restTemplate.getForObject("https://fakestoreapi.com/products/" + id,FakeStoreProductDto.class);  //return JSON object and convert to java class

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        Category category=new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        category.setId(fakeStoreProductDto.getId());
        product.setCategory(category);
//        category.setTitle(fakeStoreProductDto.getCategory());
        return product;

    }
}
