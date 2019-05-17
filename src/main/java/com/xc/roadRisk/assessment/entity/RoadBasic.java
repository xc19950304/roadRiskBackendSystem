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
@TableName("road_basic")
@ApiModel("")
public class RoadBasic extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("road_name")
    @ApiModelProperty(value = "")
    private String roadName;
    @TableField("road_level")
    @ApiModelProperty(value = "")
    private Integer roadLevel;
    @TableField("road_miles")
    @ApiModelProperty(value = "")
    private String roadMiles;
    @TableField("lanes_number")
    @ApiModelProperty(value = "")
    private Integer lanesNumber;
    @TableField("design_speed")
    @ApiModelProperty(value = "")
    private String designSpeed;
    @TableField("annual_average_daily_traffic_volume")
    @ApiModelProperty(value = "")
    private String annualAverageDailyTrafficVolume;
    @TableField("year")
    @ApiModelProperty(value = "")
    private Integer year;
    /**
     * 关联到location表中
     */
    @TableField("location_id")
    @ApiModelProperty(value = "关联到location表中")
    private Long locationId;


    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public Integer getRoadLevel() {
        return roadLevel;
    }

    public void setRoadLevel(Integer roadLevel) {
        this.roadLevel = roadLevel;
    }

    public String getRoadMiles() {
        return roadMiles;
    }

    public void setRoadMiles(String roadMiles) {
        this.roadMiles = roadMiles;
    }

    public Integer getLanesNumber() {
        return lanesNumber;
    }

    public void setLanesNumber(Integer lanesNumber) {
        this.lanesNumber = lanesNumber;
    }

    public String getDesignSpeed() {
        return designSpeed;
    }

    public void setDesignSpeed(String designSpeed) {
        this.designSpeed = designSpeed;
    }

    public String getAnnualAverageDailyTrafficVolume() {
        return annualAverageDailyTrafficVolume;
    }

    public void setAnnualAverageDailyTrafficVolume(String annualAverageDailyTrafficVolume) {
        this.annualAverageDailyTrafficVolume = annualAverageDailyTrafficVolume;
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
        return "RoadBasic{" +
        "roadName=" + roadName +
        ", roadLevel=" + roadLevel +
        ", roadMiles=" + roadMiles +
        ", lanesNumber=" + lanesNumber +
        ", designSpeed=" + designSpeed +
        ", annualAverageDailyTrafficVolume=" + annualAverageDailyTrafficVolume +
        ", year=" + year +
        ", locationId=" + locationId +
        "}";
    }
}
