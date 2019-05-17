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
import com.xc.roadRisk.assessment.entity.RainFall;
import com.xc.roadRisk.assessment.api.RainFallApi;

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
public class RainFallController {

    @Autowired
    private RainFallApi rainFallApi;

    @ApiOperation("创建单个RainFall")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @PostMapping("{version}/pv/rainFalls")
    public Response<Boolean> insert(@RequestBody RainFall rainFall) {
        return ResponseUtils.returnObjectSuccess(rainFallApi.insert(rainFall));
    }

    @ApiOperation("编辑单个RainFall")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @PutMapping("{version}/pv/rainFalls/{uid}")
    public Response<Boolean> updateById(@PathVariable("uid") Long uid, @RequestBody RainFall rainFall) {
        rainFall.setUid(uid);
        return ResponseUtils.returnObjectSuccess(rainFallApi.updateById(rainFall));
    }

    @ApiOperation("查询单个RainFall")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @GetMapping("{version}/pb/rainFalls/{uid}")
    public Response<RainFall> selectById(@PathVariable("uid") Long uid) {
        return ResponseUtils.returnObjectSuccess(rainFallApi.selectById(uid));
    }

    @ApiOperation("查询分页RainFall")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @GetMapping("{version}/pb/rainFalls/action/search")
    public Response<PageList<RainFall>> selectPage(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                                                    @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                    RainFall rainFall) {
        Page<RainFall> page = rainFallApi.selectPage(new Page<>(pageNo, pageSize), new EntityWrapper<>(rainFall));
        return ResponseUtils.returnObjectSuccess(new PageList<>(page));
    }
}
