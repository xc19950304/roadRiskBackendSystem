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
import com.xc.roadRisk.assessment.entity.GeoEnviroment;
import com.xc.roadRisk.assessment.api.GeoEnviromentApi;

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
public class GeoEnviromentController {

    @Autowired
    private GeoEnviromentApi geoEnviromentApi;

    @ApiOperation("创建单个GeoEnviroment")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @PostMapping("{version}/pv/geoEnviroments")
    public Response<Boolean> insert(@RequestBody GeoEnviroment geoEnviroment) {
        return ResponseUtils.returnObjectSuccess(geoEnviromentApi.insert(geoEnviroment));
    }

    @ApiOperation("编辑单个GeoEnviroment")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @PutMapping("{version}/pv/geoEnviroments/{uid}")
    public Response<Boolean> updateById(@PathVariable("uid") Long uid, @RequestBody GeoEnviroment geoEnviroment) {
        geoEnviroment.setUid(uid);
        return ResponseUtils.returnObjectSuccess(geoEnviromentApi.updateById(geoEnviroment));
    }

    @ApiOperation("查询单个GeoEnviroment")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @GetMapping("{version}/pb/geoEnviroments/{uid}")
    public Response<GeoEnviroment> selectById(@PathVariable("uid") Long uid) {
        return ResponseUtils.returnObjectSuccess(geoEnviromentApi.selectById(uid));
    }

    @ApiOperation("查询分页GeoEnviroment")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @GetMapping("{version}/pb/geoEnviroments/action/search")
    public Response<PageList<GeoEnviroment>> selectPage(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                                                    @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                    GeoEnviroment geoEnviroment) {
        Page<GeoEnviroment> page = geoEnviromentApi.selectPage(new Page<>(pageNo, pageSize), new EntityWrapper<>(geoEnviroment));
        return ResponseUtils.returnObjectSuccess(new PageList<>(page));
    }

    @ApiOperation(value = "测试")
    @GetMapping("/home")
    String home() {
        return "Hello World!";
    }
}
