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
import com.xc.roadRisk.assessment.entity.People;
import com.xc.roadRisk.assessment.api.PeopleApi;

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
public class PeopleController {

    @Autowired
    private PeopleApi peopleApi;

    @ApiOperation("创建单个People")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @PostMapping("{version}/pv/peoples")
    public Response<Boolean> insert(@RequestBody People people) {
        return ResponseUtils.returnObjectSuccess(peopleApi.insert(people));
    }

    @ApiOperation("编辑单个People")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @PutMapping("{version}/pv/peoples/{uid}")
    public Response<Boolean> updateById(@PathVariable("uid") Long uid, @RequestBody People people) {
        people.setUid(uid);
        return ResponseUtils.returnObjectSuccess(peopleApi.updateById(people));
    }

    @ApiOperation("查询单个People")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @GetMapping("{version}/pb/peoples/{uid}")
    public Response<People> selectById(@PathVariable("uid") Long uid) {
        return ResponseUtils.returnObjectSuccess(peopleApi.selectById(uid));
    }

    @ApiOperation("查询分页People")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @GetMapping("{version}/pb/peoples/action/search")
    public Response<PageList<People>> selectPage(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                                                    @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                    People people) {
        Page<People> page = peopleApi.selectPage(new Page<>(pageNo, pageSize), new EntityWrapper<>(people));
        return ResponseUtils.returnObjectSuccess(new PageList<>(page));
    }
}
