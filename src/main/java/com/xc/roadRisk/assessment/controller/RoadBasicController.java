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
import com.xc.roadRisk.assessment.entity.RoadBasic;
import com.xc.roadRisk.assessment.api.RoadBasicApi;

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
public class RoadBasicController {

    @Autowired
    private RoadBasicApi roadBasicApi;

    @ApiOperation("创建单个RoadBasic")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @PostMapping("{version}/pv/roadBasics")
    public Response<Boolean> insert(@RequestBody RoadBasic roadBasic) {
        return ResponseUtils.returnObjectSuccess(roadBasicApi.insert(roadBasic));
    }

    @ApiOperation("编辑单个RoadBasic")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @PutMapping("{version}/pv/roadBasics/{uid}")
    public Response<Boolean> updateById(@PathVariable("uid") Long uid, @RequestBody RoadBasic roadBasic) {
        roadBasic.setUid(uid);
        return ResponseUtils.returnObjectSuccess(roadBasicApi.updateById(roadBasic));
    }

    @ApiOperation("查询单个RoadBasic")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @GetMapping("{version}/pb/roadBasics/{uid}")
    public Response<RoadBasic> selectById(@PathVariable("uid") Long uid) {
        return ResponseUtils.returnObjectSuccess(roadBasicApi.selectById(uid));
    }

    @ApiOperation("查询分页RoadBasic")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @GetMapping("{version}/pb/roadBasics/action/search")
    public Response<PageList<RoadBasic>> selectPage(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                                                    @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                    RoadBasic roadBasic) {
        Page<RoadBasic> page = roadBasicApi.selectPage(new Page<>(pageNo, pageSize), new EntityWrapper<>(roadBasic));
        return ResponseUtils.returnObjectSuccess(new PageList<>(page));
    }
}
