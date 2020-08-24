package com.ProductBackEnd.Repository;

import com.ProductBackEnd.Model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DataMongoTest
class ProductRepoTest {
    @Autowired
    private ProductRepo productRepo;
    @Test
    void findByItemAndZipCode() {
        List<Product> products = productRepo.findByItemAndZipCode("Apple","75062");
        assertNotEquals(3,products.size());
    }

    @Test
    void findByProductName() {
        List<Product> products = productRepo.findByProductName("Apple");
        assertNotEquals(3,products.size());
    }

    @Test
    void findByProductZibCode() {
        List<Product> products = productRepo.findByProductZibCode("75062");
        assertNotEquals(3,products.size());
    }
}
