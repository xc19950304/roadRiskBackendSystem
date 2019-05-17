package com.xc.roadRisk.assessment.service;

import com.xc.roadRisk.assessment.entity.Location;
import com.xc.roadRisk.assessment.dao.LocationDao;
import com.xc.roadRisk.assessment.api.LocationApi;
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
public class LocationService extends BaseService<LocationDao, Location> implements LocationApi {

}
