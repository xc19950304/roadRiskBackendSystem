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
import com.xc.roadRisk.assessment.entity.Reservoir;
import com.xc.roadRisk.assessment.api.ReservoirApi;

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
public class ReservoirController {

    @Autowired
    private ReservoirApi reservoirApi;

    @ApiOperation("创建单个Reservoir")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @PostMapping("{version}/pv/reservoirs")
    public Response<Boolean> insert(@RequestBody Reservoir reservoir) {
        return ResponseUtils.returnObjectSuccess(reservoirApi.insert(reservoir));
    }

    @ApiOperation("编辑单个Reservoir")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @PutMapping("{version}/pv/reservoirs/{uid}")
    public Response<Boolean> updateById(@PathVariable("uid") Long uid, @RequestBody Reservoir reservoir) {
        reservoir.setUid(uid);
        return ResponseUtils.returnObjectSuccess(reservoirApi.updateById(reservoir));
    }

    @ApiOperation("查询单个Reservoir")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @GetMapping("{version}/pb/reservoirs/{uid}")
    public Response<Reservoir> selectById(@PathVariable("uid") Long uid) {
        return ResponseUtils.returnObjectSuccess(reservoirApi.selectById(uid));
    }

    @ApiOperation("查询分页Reservoir")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @GetMapping("{version}/pb/reservoirs/action/search")
    public Response<PageList<Reservoir>> selectPage(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                                                    @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                    Reservoir reservoir) {
        Page<Reservoir> page = reservoirApi.selectPage(new Page<>(pageNo, pageSize), new EntityWrapper<>(reservoir));
        return ResponseUtils.returnObjectSuccess(new PageList<>(page));
    }
}
