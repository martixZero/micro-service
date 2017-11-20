package com.micro.service.biz.service.impl;


import com.micro.service.biz.dao.CityDao;
import com.micro.service.biz.dao.ReaderMapper;
import com.micro.service.biz.entity.City;
import com.micro.service.biz.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhy
 * @date:Created in 上午11:19 2017/11/15
 */
@Service("cityService")
public class CityServiceImpl implements CityService {


    @Autowired
    private CityDao cityDao;

    @Autowired
    private ReaderMapper readerMapper;



    @Override
    public City findCityByName(String cityName) {

        System.out.println("readerMapper.selectById: "+readerMapper.selectById(1l));
        return cityDao.findById(1);

//        return cityDao.findByName(cityName);
    }

    @Override
    public void addOneCity(City city) {

        cityDao.insert(city);

//        return n;
    }
}
