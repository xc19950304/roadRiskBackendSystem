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
@TableName("rain_fall")
@ApiModel("")
public class RainFall extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("rain_fall")
    @ApiModelProperty(value = "")
    private String rainFall;
    @TableField("monitor_date")
    @ApiModelProperty(value = "")
    private Date monitorDate;
    @TableField("station_name")
    @ApiModelProperty(value = "")
    private String stationName;
    /**
     * 关联到location表中
     */
    @TableField("location_id")
    @ApiModelProperty(value = "关联到location表中")
    private Long locationId;


    public String getRainFall() {
        return rainFall;
    }

    public void setRainFall(String rainFall) {
        this.rainFall = rainFall;
    }

    public Date getMonitorDate() {
        return monitorDate;
    }

    public void setMonitorDate(Date monitorDate) {
        this.monitorDate = monitorDate;
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
        return "RainFall{" +
        "rainFall=" + rainFall +
        ", monitorDate=" + monitorDate +
        ", stationName=" + stationName +
        ", locationId=" + locationId +
        "}";
    }
}
