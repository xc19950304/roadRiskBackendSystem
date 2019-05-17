package com.xc.roadRisk.assessment.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xc.roadRisk.common.config.SwaggerAutoConfig;
import com.xc.roadRisk.common.utils.ResponseUtils;
import com.xc.roadRisk.common.vo.Response;
import com.xc.roadRisk.common.vo.PageList;
import com.xc.roadRisk.assessment.entity.RoadRiskTask;
import com.xc.roadRisk.assessment.api.RoadRiskTaskApi;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiongchang
 * @since 2019-05-06
 */
@Api(" 服务")
@RestController
public class RoadRiskTaskController {

    @Autowired
    private RoadRiskTaskApi roadRiskTaskApi;

    @ApiOperation("创建单个RoadRiskTask")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @PostMapping("{version}/pv/roadRiskTasks")
    public Response<Boolean> insert(@RequestBody RoadRiskTask roadRiskTask) {
        return ResponseUtils.returnObjectSuccess(roadRiskTaskApi.insert(roadRiskTask));
    }

    @ApiOperation("编辑单个RoadRiskTask")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @PutMapping("{version}/pv/roadRiskTasks/{uid}")
    public Response<Boolean> updateById(@PathVariable("uid") Long uid, @RequestBody RoadRiskTask roadRiskTask) {
        roadRiskTask.setUid(uid);
        return ResponseUtils.returnObjectSuccess(roadRiskTaskApi.updateById(roadRiskTask));
    }

    @ApiOperation("查询单个RoadRiskTask")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @GetMapping("{version}/pb/roadRiskTasks/{uid}")
    public Response<RoadRiskTask> selectById(@PathVariable("uid") Long uid) {
        return ResponseUtils.returnObjectSuccess(roadRiskTaskApi.selectById(uid));
    }

    @ApiOperation("查询分页RoadRiskTask")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @GetMapping("{version}/pb/roadRiskTasks/action/search")
    public Response<PageList<RoadRiskTask>> selectPage(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                                                    @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                    RoadRiskTask roadRiskTask) {
        Page<RoadRiskTask> page = roadRiskTaskApi.selectPage(new Page<>(pageNo, pageSize), new EntityWrapper<>(roadRiskTask));
        return ResponseUtils.returnObjectSuccess(new PageList<>(page));
    }
}
