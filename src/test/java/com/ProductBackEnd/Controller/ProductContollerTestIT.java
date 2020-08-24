package com.ProductBackEnd.Controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductContollerTestIT {
    private TestRestTemplate restTemplate;
    @Test
    public void contextLoads() throws JSONException {
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("productName", "Apple");
        String response = this.restTemplate.getForObject("/getproductinallloction/{productName}", String.class,uriVariables);
        JSONAssert.assertEquals("[{productid:10001},{productid:10002},{productid:10003}]",
                response, false);
    }
}
