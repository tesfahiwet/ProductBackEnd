package com.ProductBackEnd.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
    @Id
    private String id;
    private int productid;
    private String productName;
    private  String deptid;
    private String deptname;
    private  Location location;

    public Product(int productid, String productName, String deptid, String deptname, Location location) {
        this.productid = productid;
        this.productName = productName;
        this.deptid = deptid;
        this.deptname = deptname;
        this.location = location;
    }

    public Product() {
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productid=" + productid +
                ", productName='" + productName + '\'' +
                ", deptid='" + deptid + '\'' +
                ", name='" + deptname + '\'' +
                '}';

    }
}
