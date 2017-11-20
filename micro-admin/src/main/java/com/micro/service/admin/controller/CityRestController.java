package com.micro.service.admin.controller;

//import com.alibaba.fas
import com.alibaba.fastjson.JSON;
import com.micro.service.admin.vo.CityVO;
import com.micro.service.biz.entity.City;
import com.micro.service.biz.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: zhy
 * @date:Created in 上午11:22 2017/11/15
 */
@RestController
@RequestMapping("/city")
public class CityRestController {

    private static Logger logger = LoggerFactory.getLogger(CityRestController.class);

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city",method = RequestMethod.GET)
    public City getOneCity(@RequestParam(value = "cityName") String cityName){
        logger.info("req: "+cityName);
        return cityService.findCityByName(cityName);
    }


    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String getOneCity(){
        logger.info("req: asdasd");
        return JSON.toJSONString(cityService.findCityByName("松原"));
    }


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addCity(@RequestBody CityVO cityVO){
        logger.info(JSON.toJSONString(cityVO));
        logger.info("req: asdasd");
        return "test city";
    }

    public static void main(String[] args) {


        City city = new City();
        city.setCityName("beijing");
        city.setProvinceId(12L);
        System.out.println("CityRestController.main: "+JSON.toJSONString(city));
    }

}
