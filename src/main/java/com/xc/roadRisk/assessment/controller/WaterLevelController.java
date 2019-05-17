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
import com.xc.roadRisk.assessment.entity.WaterLevel;
import com.xc.roadRisk.assessment.api.WaterLevelApi;

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
public class WaterLevelController {

    @Autowired
    private WaterLevelApi waterLevelApi;

    @ApiOperation("创建单个WaterLevel")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @PostMapping("{version}/pv/waterLevels")
    public Response<Boolean> insert(@RequestBody WaterLevel waterLevel) {
        return ResponseUtils.returnObjectSuccess(waterLevelApi.insert(waterLevel));
    }

    @ApiOperation("编辑单个WaterLevel")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @PutMapping("{version}/pv/waterLevels/{uid}")
    public Response<Boolean> updateById(@PathVariable("uid") Long uid, @RequestBody WaterLevel waterLevel) {
        waterLevel.setUid(uid);
        return ResponseUtils.returnObjectSuccess(waterLevelApi.updateById(waterLevel));
    }

    @ApiOperation("查询单个WaterLevel")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @GetMapping("{version}/pb/waterLevels/{uid}")
    public Response<WaterLevel> selectById(@PathVariable("uid") Long uid) {
        return ResponseUtils.returnObjectSuccess(waterLevelApi.selectById(uid));
    }

    @ApiOperation("查询分页WaterLevel")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @GetMapping("{version}/pb/waterLevels/action/search")
    public Response<PageList<WaterLevel>> selectPage(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                                                    @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                    WaterLevel waterLevel) {
        Page<WaterLevel> page = waterLevelApi.selectPage(new Page<>(pageNo, pageSize), new EntityWrapper<>(waterLevel));
        return ResponseUtils.returnObjectSuccess(new PageList<>(page));
    }
}
