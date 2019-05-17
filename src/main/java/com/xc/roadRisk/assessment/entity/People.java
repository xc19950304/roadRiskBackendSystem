package com.xc.roadRisk.assessment.entity;

import com.xc.roadRisk.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiongchang
 * @since 2019-05-06
 */
@ApiModel("")
public class People extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("populationDensity")
    @ApiModelProperty(value = "")
    private Integer populationDensity;
    @TableField("gdp")
    @ApiModelProperty(value = "")
    private Integer gdp;
    @TableField("year")
    @ApiModelProperty(value = "")
    private Integer year;
    /**
     * 关联到location表中
     */
    @TableField("location_id")
    @ApiModelProperty(value = "关联到location表中")
    private Long locationId;


    public Integer getPopulationDensity() {
        return populationDensity;
    }

    public void setPopulationDensity(Integer populationDensity) {
        this.populationDensity = populationDensity;
    }

    public Integer getGdp() {
        return gdp;
    }

    public void setGdp(Integer gdp) {
        this.gdp = gdp;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "People{" +
        "populationDensity=" + populationDensity +
        ", gdp=" + gdp +
        ", year=" + year +
        ", locationId=" + locationId +
        "}";
    }
}
