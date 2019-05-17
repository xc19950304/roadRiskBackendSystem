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
import com.xc.roadRisk.assessment.entity.TaskType;
import com.xc.roadRisk.assessment.api.TaskTypeApi;

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
public class TaskTypeController {

    @Autowired
    private TaskTypeApi taskTypeApi;

    @ApiOperation("创建单个TaskType")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @PostMapping("{version}/pv/taskTypes")
    public Response<Boolean> insert(@RequestBody TaskType taskType) {
        return ResponseUtils.returnObjectSuccess(taskTypeApi.insert(taskType));
    }

    @ApiOperation("编辑单个TaskType")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @PutMapping("{version}/pv/taskTypes/{uid}")
    public Response<Boolean> updateById(@PathVariable("uid") Long uid, @RequestBody TaskType taskType) {
        taskType.setUid(uid);
        return ResponseUtils.returnObjectSuccess(taskTypeApi.updateById(taskType));
    }

    @ApiOperation("查询单个TaskType")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @GetMapping("{version}/pb/taskTypes/{uid}")
    public Response<TaskType> selectById(@PathVariable("uid") Long uid) {
        return ResponseUtils.returnObjectSuccess(taskTypeApi.selectById(uid));
    }

    @ApiOperation("查询分页TaskType")
    @ApiImplicitParam(name = "version", paramType = "path", allowableValues = SwaggerAutoConfig.COMPATIBLE_VERSION, required = true)
    @GetMapping("{version}/pb/taskTypes/action/search")
    public Response<PageList<TaskType>> selectPage(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                                                    @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                    TaskType taskType) {
        Page<TaskType> page = taskTypeApi.selectPage(new Page<>(pageNo, pageSize), new EntityWrapper<>(taskType));
        return ResponseUtils.returnObjectSuccess(new PageList<>(page));
    }
}
