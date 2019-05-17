package com.xc.roadRisk.common.base;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xc.roadRisk.common.id.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Copyright (c) 2017-2018 Wuhan Yryz Network Company LTD.
 * All rights reserved.
 * <p>
 * Created on 2018/9/5 15:38
 * Created by lifan
 */
@Transactional
public abstract class BaseService<M extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> {

    @Autowired
    protected SnowflakeIdWorker snowflakeIdWorker;

    @Autowired
    protected ObjectMapper objectMapper;

    @Override
    public boolean insert(T entity) {
        entity.setId(null);
        entity.setUid(snowflakeIdWorker.nextId());
        return super.insert(entity);
    }

    @Override
    public boolean insertAllColumn(T entity) {
        entity.setId(null);
        entity.setUid(snowflakeIdWorker.nextId());
        return super.insertAllColumn(entity);
    }

    @Override
    public boolean insertBatch(List<T> entityList, int batchSize) {
        if (!CollectionUtils.isEmpty(entityList)) {
            entityList.forEach(entity -> {
                entity.setId(null);
                entity.setUid(snowflakeIdWorker.nextId());
            });
        }
        return super.insertBatch(entityList, batchSize);
    }

    @Override
    public boolean updateById(T entity) {
        entity.setId(null);
        return super.updateById(entity);
    }

    @Override
    public boolean updateAllColumnById(T entity) {
        entity.setId(null);
        return super.updateAllColumnById(entity);
    }

    @Override
    public boolean updateBatchById(List<T> entityList, int batchSize) {
        if (!CollectionUtils.isEmpty(entityList)) {
            entityList.forEach(entity -> {
                entity.setId(null);
            });
        }
        return super.updateBatchById(entityList, batchSize);
    }
}
