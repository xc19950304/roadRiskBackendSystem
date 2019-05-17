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
@TableName("road_risk_task")
@ApiModel("")
public class RoadRiskTask extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("task_name")
    @ApiModelProperty(value = "")
    private String taskName;
    @TableField("task_status")
    @ApiModelProperty(value = "")
    private Integer taskStatus;
    @TableField("type_id")
    @ApiModelProperty(value = "")
    private Integer typeId;


    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "RoadRiskTask{" +
        "taskName=" + taskName +
        ", taskStatus=" + taskStatus +
        ", typeId=" + typeId +
        "}";
    }
}
