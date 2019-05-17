package com.xc.roadRisk.assessment.service;

import com.xc.roadRisk.assessment.entity.RoadRiskTask;
import com.xc.roadRisk.assessment.dao.RoadRiskTaskDao;
import com.xc.roadRisk.assessment.api.RoadRiskTaskApi;
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
public class RoadRiskTaskService extends BaseService<RoadRiskTaskDao, RoadRiskTask> implements RoadRiskTaskApi {

}
