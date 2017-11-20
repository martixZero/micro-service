package com.micro.service.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: zhy
 * @date:Created in 下午4:03 2017/11/15
 */
@RestController("/test")
public class TestController {

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String getTest(){
        System.out.println("TestController.getTest");
        return "asdasdas";
    }

}
