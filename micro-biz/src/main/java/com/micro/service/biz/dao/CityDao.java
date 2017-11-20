package com.micro.service.biz.dao;

import com.micro.service.biz.entity.City;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 *
 * @author zhy
 * @Date 2017/11/15 上午11:07
 */
@Service
public interface CityDao {

    /**
     * 通过城市名称查询城市信息
     * @param cityName
     * @return
     */
    City findByName(@Param("cityName") String cityName);


    /**
     * 通过id获取信息
     * @param id
     * @return
     */
    City findById(@Param("id") Integer id);



    Integer insert(City city);

}
