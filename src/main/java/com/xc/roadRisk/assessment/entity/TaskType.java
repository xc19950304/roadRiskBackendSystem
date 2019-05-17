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
@TableName("task_type")
@ApiModel("")
public class TaskType extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("type_name")
    @ApiModelProperty(value = "")
    private String typeName;
    @TableField("type_id")
    @ApiModelProperty(value = "")
    private Integer typeId;


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "TaskType{" +
        "typeName=" + typeName +
        ", typeId=" + typeId +
        "}";
    }
}
