package com.ProductBackEnd.Proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="Location")
@RibbonClient(name="Location")
public interface LocationServiceProxy {
@GetMapping("/loction")
    public ProductBean getLocationItem();

@PostMapping("/loction")
    public void createLoction();
}
