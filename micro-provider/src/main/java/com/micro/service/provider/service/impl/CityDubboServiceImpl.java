package com.micro.service.provider.service.impl;


import com.micro.service.api.CityDubboService;
import com.micro.service.biz.service.CityService;
import com.micro.service.dto.CityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhy
 * @date:Created in 下午4:16 2017/11/17
 */
public class CityDubboServiceImpl implements CityDubboService {


    @Autowired
    private CityService cityService;
    @Override
    public CityDTO findCityByName(String cityName) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setCityName("dubbo");
        cityDTO.setProvinceId(100L);
        cityDTO.setDescription("good");
        return cityDTO;
    }
}
