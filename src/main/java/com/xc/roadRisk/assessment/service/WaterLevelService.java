package com.xc.roadRisk.assessment.service;

import com.xc.roadRisk.assessment.entity.WaterLevel;
import com.xc.roadRisk.assessment.dao.WaterLevelDao;
import com.xc.roadRisk.assessment.api.WaterLevelApi;
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
public class WaterLevelService extends BaseService<WaterLevelDao, WaterLevel> implements WaterLevelApi {

}
