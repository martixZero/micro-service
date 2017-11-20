package com.micro.service.dto;

import java.io.Serializable;

/**
 * @description:外部dto
 * @author: zhy
 * @date:Created in 下午4:12 2017/11/17
 */
public class CityDTO  implements Serializable{

    private static final long serialVersionUID = 1L;


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

    @Override
    public String toString() {
        return "CityDTO{" +
                "provinceId=" + provinceId +
                ", cityName='" + cityName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityDTO cityDTO = (CityDTO) o;

        if (provinceId != null ? !provinceId.equals(cityDTO.provinceId) : cityDTO.provinceId != null) return false;
        if (cityName != null ? !cityName.equals(cityDTO.cityName) : cityDTO.cityName != null) return false;
        return description != null ? description.equals(cityDTO.description) : cityDTO.description == null;
    }

    @Override
    public int hashCode() {
        int result = provinceId != null ? provinceId.hashCode() : 0;
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
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
