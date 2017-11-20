package com.micro.service.admin.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @description:
 * @author: zhy
 * @date:Created in 下午3:58 2017/11/16
 */
public class CityVO {


    /**
     * 城市编号
     */
    private Long id;

    /**
     * 省份编号
     */
    private Long provinceId;

    /**
     * 城市名称
     */
    private String cityName;


    /**
     * 描述
     */
    private String description;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date date;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CityVO() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
