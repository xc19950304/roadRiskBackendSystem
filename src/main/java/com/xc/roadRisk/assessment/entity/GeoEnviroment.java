package com.xc.roadRisk.assessment.entity;

import com.baomidou.mybatisplus.annotations.TableName;
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
@TableName("geo_enviroment")
@ApiModel("")
public class GeoEnviroment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("slope")
    @ApiModelProperty(value = "")
    private String slope;
    @TableField("soil_erosion_level")
    @ApiModelProperty(value = "")
    private Integer soilErosionLevel;
    @TableField("year")
    @ApiModelProperty(value = "")
    private Integer year;
    /**
     * 关联到location表中
     */
    @TableField("location_id")
    @ApiModelProperty(value = "关联到location表中")
    private Long locationId;


    public String getSlope() {
        return slope;
    }

    public void setSlope(String slope) {
        this.slope = slope;
    }

    public Integer getSoilErosionLevel() {
        return soilErosionLevel;
    }

    public void setSoilErosionLevel(Integer soilErosionLevel) {
        this.soilErosionLevel = soilErosionLevel;
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
        return "GeoEnviroment{" +
        "slope=" + slope +
        ", soilErosionLevel=" + soilErosionLevel +
        ", year=" + year +
        ", locationId=" + locationId +
        "}";
    }
}
