package com.iotronicsinnovations.springbootproject.Service;

import com.iotronicsinnovations.springbootproject.Models.Category;
import com.iotronicsinnovations.springbootproject.Models.Product;
import com.iotronicsinnovations.springbootproject.dtos.FakeStoreProductDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//@Component
@Service//Use any component  or service
//@Service("fakestoreProductService")
public class FakeStoreProductService implements ProductService {
    RestTemplate restTemplate;

    //Spring will look inside to check whether it has spring object

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public Product getSingleProduct(Long id) {

//        Instead of writing Resttemplate here we will use it through Beans
//        RestTemplate restTemplate = new RestTemplate();
        //RestTemplate restTemplate;
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        // return JSON object and convert to java class
//        ResponseEntity<FakeStoreProductDto> responseEntity= restTemplate
//                .getForEntity("https:fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
//
//        if(responseEntity.getStatusCode()== HttpStatusCode.valueOf(200)){
//
//        }
        //After Doing All this create FakeStoreProductDTO

//        FakeStoreProductDto fakeStoreProductDto=responseEntity.getBody();
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        category.setId(fakeStoreProductDto.getId());
        product.setCategory(category);
//        category.setTitle(fakeStoreProductDto.getCategory());
        return product;
    }


//    @Override
//    public Product createProduct(String title, String Description, String ImageUrl, String Category, double price) {
//        FakeStoreProductDto fakeStoreProductDto =new FakeStoreProductDto();
//        fakeStoreProductDto.setTitle(title);
//        fakeStoreProductDto.setDescription(Description);
//        fakeStoreProductDto.setImage(ImageUrl);
//        fakeStoreProductDto.setCategory(Category);
//        fakeStoreProductDto.setPrice(price);
//
//        FakeStoreProductDto response = restTemplate
//                .postForObject("https://fakestoreapi.com/products",
//                       fakeStoreProductDto,FakeStoreProductDto.class);
//    //This Create Product should return  Product
//    //copy and paste the above  code from get a single Product as for scalability
////        Product product = new Product();
////        product.setId(fakeStoreProductDto.getId());
////        product.setTitle(fakeStoreProductDto.getTitle());
////        product.setDescription(fakeStoreProductDto.getDescription());
////        product.setPrice(fakeStoreProductDto.getPrice());
////        product.setImageUrl(fakeStoreProductDto.getImage());
////        Category category = new Category();
////        category.setTitle(fakeStoreProductDto.getCategory());
////        category.setId(fakeStoreProductDto.getId());
////        product.setCategory(category);
//        //this is not a good idea so ( make a method in fakestoreproductDto) toProduct
//       return response.toProduct();
//    }


    @Override
    public Product createProduct(String title, String description, String image, String category, double price) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setImage(image);
        fakeStoreProductDto.setCategory(category);

        FakeStoreProductDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeStoreProductDto,
                FakeStoreProductDto.class
        );
        return response.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
//        List<FakeStoreProductDto> response = restTemplate
//                .getForObject("https://fakestoreapi.com/products",
//                        List.class);

        FakeStoreProductDto[] response = restTemplate
                .getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class);


        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : response){
            products.add(fakeStoreProductDto.toProduct());
        }
        return products;
    }


}
