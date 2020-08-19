package com.Product.Controller;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ProductBackEnd.Controller.ProductController;
import com.ProductBackEnd.Model.Location;
import com.ProductBackEnd.Model.Product;
import com.ProductBackEnd.Repository.ProductRepo;
import com.ProductBackEnd.Service.ProductService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value= ProductController.class)
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductService productService;
    @MockBean
    private ProductRepo productRepo;

    @Test
    void createProduct() {
    }

    @Test
    void getavailableItemsInGivenLocation() throws Exception {

    }

    @Test
    void getProductAllLocation() throws Exception {
    	Location l =new Location(1001,"Irving","75062");
        List<Product> productList = new ArrayList<>();
        Product p1= new Product(10001,"Apple","102","Mac",l);
        
        productList.add(p1);
        String productName="Apple";
        when(productService.getProductAllLocation("Apple")).thenReturn(productList);
        
        //call "/hello-world" GET appliction/json
        RequestBuilder request= MockMvcRequestBuilders.
                get("/getproductallloction").param("productName", productName).
                accept(MediaType.APPLICATION_JSON);
        
        MvcResult result = mockMvc.perform(request)
                //.andExpect(status().is(200))
              .andExpect(status().isOk())
               // .andExpect(status().is4xxClientError())
                .andExpect(content().json("[{productid: 10001,productName:Apple,deptid: 102,deptname: Mac, location:{locationId:10001,locationname:Irving,zibCode:75062}}]"))
                .andReturn();
    }
}
