package com.micro.service.api;


import com.micro.service.dto.CityDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @description:城市服务外部接口
 * @author: zhy
 * @date:Created in 下午4:10 2017/11/17
 */

@Path("/city")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public interface CityDubboService {

    /**
     * 通过名字获取城市信息
     * @param cityName
     * @return
     */
    @POST
    @Path("/find")
    CityDTO findCityByName(String cityName);

}
