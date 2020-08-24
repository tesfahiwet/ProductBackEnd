package com.ProductBackEnd.Service;

import com.ProductBackEnd.Exception.InvalidInputException;
import com.ProductBackEnd.Model.Location;
import com.ProductBackEnd.Model.Product;
import com.ProductBackEnd.Model.ProductBalanace;
import com.ProductBackEnd.Repository.ProductRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ProductServiceTest {
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
@InjectMocks
private ProductService productService;
@Mock
private ProductRepo productRepo;
    @Test
    void getavailableItemsInGivenLocation() throws InvalidInputException {
        when(productRepo.findByItemAndZipCode("Apple","75062"))
                .thenReturn(Arrays.asList(new Product(1001,"Apple","1001","Mac",
                        new Location(10001,"Irving","75062")),
                		new Product(1001,"Apple","1001","Mac",
                                new Location(10001,"Irving","75062")),
                		new Product(1001,"Apple","1001","Mac",
                                new Location(10001,"Irving","75062"))));
       ProductBalanace P= productService.getavailableItemsInGivenLocation("Apple","75062");

        assertEquals(3, P.getBalance());
    }

    @Test
    void getProductAllLocation() {
    	 when(productRepo.findByProductName("Apple"))
		.thenReturn(Arrays.asList(new Product(1001,"Apple","1001","Mac",
		        new Location(10001,"Irving","75062")),
				new Product(1001,"Apple","1001","Mac",
				        new Location(10001,"Irving","75062")),
				new Product(1001,"Apple","1001","Mac",
				        new Location(10001,"Irving","75062"))));
//    	logger.info("{}", pm);
        List<Product> P= productRepo.findByProductName("Apple");
        assertEquals("Apple", P.get(0).getProductName());
    }

    @Test
    void getnearestItemNot() {
        List<Product> products= Arrays.asList(new Product(1001, "Apple", "1001", "Mac",
                new Location(10001, "Irving", "75062")));
        List<String> zipcode = Arrays.asList("75038","75062","75032","75062");
      //  for(String zip: zipcode) {
            when(productRepo.findByItemAndZipCode("Apple1",zipcode.get(3) ))
                    .thenReturn(Arrays.asList(new Product(1001, "Apple", "1001", "Mac",
                                    new Location(10001, "Irving", "75062"))));
      //  }
        List<Product> P= productRepo.findByItemAndZipCode("Apple",zipcode.get(3));
        assertNotEquals(products, P);
    }
}
