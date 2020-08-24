package com.ProductBackEnd.Service;

import com.ProductBackEnd.Exception.InvalidInputException;
import com.ProductBackEnd.Model.Product;
import com.ProductBackEnd.Model.ProductBalanace;
import com.ProductBackEnd.Repository.ProductRepo;
import com.mongodb.MongoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProductRepo productRepo;
    MongoClient mongoClient;
    public ProductBalanace getavailableItemsInGivenLocation(String productName, String zip_code ) throws InvalidInputException {

        List<Product> products=  productRepo.findByItemAndZipCode(productName, zip_code);
      //  Product p= products.stream().findFirst().orElseThrow(()-> throw new InvalidInputException("   : This No Product Related to your Input in this Location   "));
        logger.info("{}",products);
        ProductBalanace PB= new ProductBalanace();
        if(products.size()==0){
            throw new InvalidInputException("   : This No Product Related to your Input in this Location   ");
        }
        PB.setProductid(products.get(0).getProductid());
        PB.setLocationId(products.get(0).getLocation().getLocationId());
        PB.setBalance(products.size());

        return PB;

    }

    public List<Product> getProductAllLocation(String productname) throws InvalidInputException {
//        MongoCollection<Document> BD=mongoClient.getDatabase("").getCollection("");
//
//
//        DBCursor =;
//        DB db = mongoClient.getDB("");
//        DBCollection coll = db.getCollection("");
//        DBCursor carCursor = coll.find({ 'productName': productname},{'productName':1}).pretty();
//        logger.info("{}",productRepo.findByProductName(productname));
        List<Product> products1=  productRepo.findByProductName(productname);
//        List<String> products=  productRepo.findByProductName(productname).stream().map(p->p.getProductName()).collect(Collectors.toList());
//        if(products.size()==0){
//            throw new InvalidInputException("   : This No Product Related to your Input in this Location   ");
//        }
        logger.info("{}",products1);




return products1;
        //return products;

    }

	public List<Product> getnearestItem(String productname, List<String> listZip) {
		List<Product> products= new ArrayList<>();
		
		for(String zip:listZip ) {
			productRepo.findByItemAndZipCode(productname, zip);
			products.addAll(productRepo.findByItemAndZipCode(productname, zip));
			
		}
		return products;
		 
	}
}
