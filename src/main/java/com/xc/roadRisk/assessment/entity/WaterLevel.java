package com.xc.roadRisk.assessment.entity;

import java.util.Date;
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
@TableName("water_level")
@ApiModel("")
public class WaterLevel extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("water_level")
    @ApiModelProperty(value = "")
    private String waterLevel;
    @TableField("flow")
    @ApiModelProperty(value = "")
    private String flow;
    @TableField("monitor_time")
    @ApiModelProperty(value = "")
    private Date monitorTime;
    @TableField("waring_water_level")
    @ApiModelProperty(value = "")
    private String waringWaterLevel;
    @TableField("station_name")
    @ApiModelProperty(value = "")
    private String stationName;
    /**
     * 关联到location表中
     */
    @TableField("location_id")
    @ApiModelProperty(value = "关联到location表中")
    private Long locationId;


    public String getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(String waterLevel) {
        this.waterLevel = waterLevel;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public Date getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(Date monitorTime) {
        this.monitorTime = monitorTime;
    }

    public String getWaringWaterLevel() {
        return waringWaterLevel;
    }

    public void setWaringWaterLevel(String waringWaterLevel) {
        this.waringWaterLevel = waringWaterLevel;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "WaterLevel{" +
        "waterLevel=" + waterLevel +
        ", flow=" + flow +
        ", monitorTime=" + monitorTime +
        ", waringWaterLevel=" + waringWaterLevel +
        ", stationName=" + stationName +
        ", locationId=" + locationId +
        "}";
    }
}
