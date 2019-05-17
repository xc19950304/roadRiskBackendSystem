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
import com.xc.roadRisk.assessment.entity.Location;
import com.xc.roadRisk.assessment.api.LocationApi;

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
public class LocationController {

    @Autowired
    private LocationApi locationApi;

    @ApiOperation("创建单个Location")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @PostMapping("{version}/pv/locations")
    public Response<Boolean> insert(@RequestBody Location location) {
        return ResponseUtils.returnObjectSuccess(locationApi.insert(location));
    }

    @ApiOperation("编辑单个Location")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @PutMapping("{version}/pv/locations/{uid}")
    public Response<Boolean> updateById(@PathVariable("uid") Long uid, @RequestBody Location location) {
        location.setUid(uid);
        return ResponseUtils.returnObjectSuccess(locationApi.updateById(location));
    }

    @ApiOperation("查询单个Location")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @GetMapping("{version}/pb/locations/{uid}")
    public Response<Location> selectById(@PathVariable("uid") Long uid) {
        return ResponseUtils.returnObjectSuccess(locationApi.selectById(uid));
    }

    @ApiOperation("查询分页Location")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @GetMapping("{version}/pb/locations/action/search")
    public Response<PageList<Location>> selectPage(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                                                    @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                    Location location) {
        Page<Location> page = locationApi.selectPage(new Page<>(pageNo, pageSize), new EntityWrapper<>(location));
        return ResponseUtils.returnObjectSuccess(new PageList<>(page));
    }
}
