package com.xc.roadRisk.assessment.service;

import com.xc.roadRisk.assessment.entity.People;
import com.xc.roadRisk.assessment.dao.PeopleDao;
import com.xc.roadRisk.assessment.api.PeopleApi;
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
public class PeopleService extends BaseService<PeopleDao, People> implements PeopleApi {

}
