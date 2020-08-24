package com.ProductBackEnd.Repository;

import com.ProductBackEnd.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableMongoRepositories
@Repository
public interface ProductRepo extends MongoRepository<Product, String> {
    @Query("{ 'productName': ?0, 'location.zip_code': ?1}")
    List<Product> findByItemAndZipCode(String productName, String zip_code);
//    @Query("{ 'productName': ?0}")
//    @Query(value="{ 'productName': ?0}" , fields="{'productName':1},'id:0")
//    List<Product>  findByProductName(String productname);
    @Query(value="{ 'productName': ?0}")
    List<Product>  findByProductName(String productName);
//    List<Product> findByTitleContaining(String title);
    @Query(value="{ 'location.zip_code': ?0}")
    List<Product>  findByProductZibCode(String zip_code);
}
