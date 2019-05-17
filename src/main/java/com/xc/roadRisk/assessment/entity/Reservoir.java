package com.xc.roadRisk.assessment.entity;

import java.util.Date;
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
public class Reservoir extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("reservoir_name")
    @ApiModelProperty(value = "")
    private String reservoirName;
    @TableField("reservoir_storage")
    @ApiModelProperty(value = "")
    private String reservoirStorage;
    @TableField("monitor_date")
    @ApiModelProperty(value = "")
    private Date monitorDate;
    /**
     * 关联到location表中
     */
    @TableField("location_id")
    @ApiModelProperty(value = "关联到location表中")
    private Long locationId;


    public String getReservoirName() {
        return reservoirName;
    }

    public void setReservoirName(String reservoirName) {
        this.reservoirName = reservoirName;
    }

    public String getReservoirStorage() {
        return reservoirStorage;
    }

    public void setReservoirStorage(String reservoirStorage) {
        this.reservoirStorage = reservoirStorage;
    }

    public Date getMonitorDate() {
        return monitorDate;
    }

    public void setMonitorDate(Date monitorDate) {
        this.monitorDate = monitorDate;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "Reservoir{" +
        "reservoirName=" + reservoirName +
        ", reservoirStorage=" + reservoirStorage +
        ", monitorDate=" + monitorDate +
        ", locationId=" + locationId +
        "}";
    }
}
