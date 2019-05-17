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
public class Location extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("location_name")
    @ApiModelProperty(value = "")
    private String locationName;
    @TableField("remarks")
    @ApiModelProperty(value = "")
    private String remarks;


    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Location{" +
        "locationName=" + locationName +
        ", remarks=" + remarks +
        "}";
    }
}
