package com.ProductBackEnd.Repository;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.ProductBackEnd.Model.Product;

import java.util.List;

@EnableMongoRepositories
@Repository
public interface ProductRepo extends MongoRepository<Product, String> {
    @Query("{ 'productName': ?0, 'location.zip_code': ?1}")
    List<Product> findByItemAndZipCode(String productName, String zibCode);
//    @Query("{ 'productName': ?0}")
//    @Query(value="{ 'productName': ?0}" , fields="{'productName':1},'id:0")
//    List<Product>  findByProductName(String productname);
    @Query(value="{ 'productName': ?0}")
    List<Product>  findByProductName(String productName);
//    List<Product> findByTitleContaining(String title);
    @Query(value="{ 'location.zibCode': ?1}")
    List<Product>  findByProductZibCode(String zibCode);
}
