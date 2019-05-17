package com.example.demo.controller;

import com.example.demo.entity.School;
;
import com.example.demo.services.SchoolService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class SampleController {
    @Autowired
    private SchoolService schoolService;


    @ApiOperation(value = "测试")
    @GetMapping("/home")
    String home() {
        return "Hello World!";
    }


    @ApiOperation(value = "采取mybatis方式查询")
    @ApiImplicitParam(name = "id", value = "用户id", paramType = "path", required = true)
    @GetMapping("/schools/maybatis/{id}")
    public School helloSchool1(@PathVariable("id") int id) {
        School school = schoolService.getSchoolById(id);
        System.out.println(school);
        return school;
    }

    @ApiOperation(value = "采取mybatis-plus方式查询")
    @ApiImplicitParam(name = "id", value = "用户id", paramType = "path", required = true)
    @GetMapping("/schools/maybatis-plus/{id}")
    public School helloSchool2(@PathVariable("id") int id) {
        School school = schoolService.selectById(id);
        System.out.println(school);
        return school;
    }

    @ApiOperation(value = "插入数据")
    @ApiImplicitParam(name = "school", value = "学校信息", paramType = "body", required = true)
    @PostMapping("/schools")
    public Boolean insertSchool(@RequestBody School school) {
        Boolean tag = schoolService.insert(school);
        System.out.println(tag);
        return tag;
    }
}