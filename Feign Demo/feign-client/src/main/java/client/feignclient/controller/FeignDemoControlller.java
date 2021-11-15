package client.feignclient.controller;

import client.feignclient.utils.FeignServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class FeignDemoControlller {
    @Autowired
    private FeignServiceUtil feignServiceUtil;
    @GetMapping("/username")
    public String getUserName(){
        return feignServiceUtil.getName();
    }
    @GetMapping("/userAddress")
    public String userAddress(){
        return feignServiceUtil.getAddress();
    }
    @GetMapping("/userstatus")
    public String userstatus(){
        return feignServiceUtil.getStatus();
    }

}
