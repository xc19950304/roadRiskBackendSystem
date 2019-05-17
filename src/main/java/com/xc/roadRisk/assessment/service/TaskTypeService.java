package com.xc.roadRisk.assessment.service;

import com.xc.roadRisk.assessment.entity.TaskType;
import com.xc.roadRisk.assessment.dao.TaskTypeDao;
import com.xc.roadRisk.assessment.api.TaskTypeApi;
import com.xc.roadRisk.common.base.BaseService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiongchang
 * @since 2019-05-06
 */
@Service
public class TaskTypeService extends BaseService<TaskTypeDao, TaskType> implements TaskTypeApi {

}
