package com.micro.service.biz.service;


import com.micro.service.biz.entity.City;


/**
 * @description:
 * @author: zhy
 * @date:Created in 上午11:17 2017/11/15
 */


public interface CityService {

    /**
     * 通过名字获取城市信息
     * @param cityName
     * @return
     */

    City findCityByName(String cityName);

    /**
     * 添加城市
     * @param city
     * @return
     */
    void addOneCity(City city);



}
