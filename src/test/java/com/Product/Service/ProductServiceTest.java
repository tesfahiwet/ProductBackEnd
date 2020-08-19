package com.Product.Service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.ProductBackEnd.Exception.InvalidInputException;
import com.ProductBackEnd.Model.Location;
import com.ProductBackEnd.Model.Product;
import com.ProductBackEnd.Model.ProductBalanace;
import com.ProductBackEnd.Repository.ProductRepo;
import com.ProductBackEnd.Service.ProductService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProductServiceTest {
@InjectMocks
private ProductService productService;
@Mock
private ProductRepo productRepo;
    @Test
    void getavailableItemsInGivenLocation() throws InvalidInputException {
        when(productRepo.findByItemAndZipCode("Apple","75062"))
                .thenReturn(Arrays.asList(new Product(1001,"Apple","1001","Mac",
                        new Location(10001,"Irving","75062"))));
       ProductBalanace P= productService.getavailableItemsInGivenLocation("Apple","75062");

        assertEquals(1, P.getBalance());
    }

    @Test
    void getProductAllLocation() {
        when(productRepo.findByProductName("Appe"))
                .thenReturn(Arrays.asList(new Product(1001,"Apple","1001","Mac",
                        new Location(10001,"Irving","75062"))));
        List<Product> P= productRepo.findByProductName("Apple");
        assertEquals("Apple", P.get(0).getProductName());
    }
}
