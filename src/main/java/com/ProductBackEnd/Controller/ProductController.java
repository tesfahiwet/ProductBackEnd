package com.ProductBackEnd.Controller;

import com.ProductBackEnd.Exception.InvalidInputException;
import com.ProductBackEnd.Model.*;
import com.ProductBackEnd.Repository.ProductRepo;
import com.ProductBackEnd.Service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins="http://localhost:4200")
//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private  ProductService productService;
    @Autowired
    private ProductRepo productRepo;

    @PostMapping("/product")
    public void createProduct(@RequestBody Product Pb){
Product p= new Product();
Location l = new Location();
l.setLocationId(Pb.getLocation().getLocationId());
        l.setLocationname(Pb.getLocation().getLocationname());
       l.setZip_code(Pb.getLocation().getZip_code());

p.setProductid(Pb.getProductid()); p.setProductName(Pb.getProductName());

p.setDeptid(Pb.getDeptid()); p.setDeptname(Pb.getDeptname()); p.setLocation(l);
logger.info("{}",Pb.getLocation());
        logger.info("{}",Pb);
        productRepo.save(p);


    }
//available items in a given location. 
    @PostMapping("/availableitemsinlocation")
    public ProductBalanace getavailableItemsInGivenLocation(@RequestBody ProductBalanceIn productBalanceIn ) throws InvalidInputException {
//        logger.info("{}",productService.getavailableItemsInGivenLocation(productBalanceIn.getProductName(),productBalanceIn.getZibCode()));
        String productName = productBalanceIn.getProductName();
        String zip_code = productBalanceIn.getZip_code();
        ProductBalanace PB =new ProductBalanace();
       try {
          return productService.getavailableItemsInGivenLocation(productName,zip_code);
       }catch (InvalidInputException  e){
           e.getMessage();
       }

        return productService.getavailableItemsInGivenLocation(productName,zip_code);
    }
   // Find the availability of a given item and/or department in all locations
    @GetMapping("/getproductinallloction/{productname}")
    public List<Product> getProductAllLocation(@PathVariable String productname) throws InvalidInputException {
        productService.getProductAllLocation(productname);
        return  productService.getProductAllLocation(productname);
    }
    @GetMapping("/getproductByZibCode")
    public List<Product> getProductByZibCode(@RequestParam String zip_code) throws InvalidInputException {
      //  productService.getProductAllLocation(zibCode);
        return  productRepo.findByProductZibCode(zip_code);
    }
    @GetMapping("/getproductZibCode/{productname}/{zip_code}/{distance}")
    public List<Product> findNearest(@PathVariable String productname, @PathVariable String zip_code, @PathVariable String distance){
      //  productService.getProductAllLocation(zibCode);
    	Map<String, Object> uriVariables = new HashMap<>();
    	uriVariables.put("zip_code", zip_code);
		uriVariables.put("distance", distance);
    	ResponseEntity<NearestLocation> responseEntity= new RestTemplate().getForEntity(
    			"https://www.zipcodeapi.com/rest/Ps2DvZZZBrI4XqpQoRRp9RCfnPpOk7SrS2FdHaebNRnLhMF6q85921wNVsszTqRg/radius.json/{zip_code}/{distance}/mile",
    			NearestLocation.class,uriVariables);
    	logger.info("{}", responseEntity);
    	NearestLocation	response = responseEntity.getBody();
    	List<String> listZip=response.getZip_codes().stream().map(x->x.getZip_code())
    			.collect(Collectors.toList());
    	
    	logger.info("{}", response);
        return productService.getnearestItem(productname,listZip);
    }
    
    @GetMapping("/getproductZibCodetest")
    public NearestLocation findNearesttest()  {
    	NearestLocation n= new NearestLocation();
    	Zip_codes z= new Zip_codes("irving", 100, "Texas", "45434");
       	Zip_codes z1= new Zip_codes("irving", 100, "Texas", "45434");
       	Zip_codes z2= new Zip_codes("irving", 100, "Texas", "45434");
    	List<Zip_codes>  zc= new ArrayList<>();
    	zc.add(z); zc.add(z1); zc.add(z2); 
    	n.setZip_codes(zc);
        return n;
    }  
}
