package com.ProductBackEnd.Model;

public class ProductBalanceIn {
  private String  productName;
    private String  zip_code;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }



    public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	@Override
    public String toString() {
        return "ProductBalanceIn{" +
                "productName='" + productName + '\'' +
                ", zip_code='" + zip_code + '\'' +
                '}';
    }
}
