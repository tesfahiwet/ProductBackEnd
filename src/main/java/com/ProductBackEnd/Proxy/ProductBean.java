package com.ProductBackEnd.Proxy;

public class ProductBean {
    private Long productid;
    private String productName;
    private  String deptid;
    private String deptname;
    private Long locationId;
    private String locationname;
    private String ZibCode;

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
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

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getLocationname() {
        return locationname;
    }

    public void setLocationname(String locationname) {
        this.locationname = locationname;
    }

    public String getZibCode() {
        return ZibCode;
    }

    public void setZibCode(String zibCode) {
        ZibCode = zibCode;
    }

    @Override
    public String toString() {
        return "ProductBean{" +
                "productid=" + productid +
                ", productName='" + productName + '\'' +
                ", deptid='" + deptid + '\'' +
                ", deptname='" + deptname + '\'' +
                ", locationId=" + locationId +
                ", locationname='" + locationname + '\'' +
                ", ZibCode='" + ZibCode + '\'' +
                '}';
    }
}
