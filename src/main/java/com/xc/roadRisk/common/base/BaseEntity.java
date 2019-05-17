package com.xc.roadRisk.common.base;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.swagger.annotations.ApiModelProperty;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 8963343084009468631L;

    //数据库自增ID
    @TableField("id")
    @ApiModelProperty(value = "数据库自增ID", hidden = true)
    private Long id;

    //分布式唯一ID
    @TableId(value = "uid", type = IdType.INPUT)
    @ApiModelProperty(value = "分布式唯一ID")
    private Long uid;

    @TableField("create_user_id")
    @ApiModelProperty(value = "创建人ID")
    private Long createUserId;

    @TableField("create_date")
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @TableField("last_update_user_id")
    @ApiModelProperty(value = "最后修改人ID")
    private Long lastUpdateUserId;

    @TableField("last_update_date")
    @ApiModelProperty(value = "最后修改时间")
    private Date lastUpdateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Long lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public static class HiddenStringSerializer extends JsonSerializer<String> {
        @Override
        public void serialize(String t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNull();
        }
    }
}
