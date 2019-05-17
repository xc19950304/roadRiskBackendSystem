package com.example.demo.services;

import com.baomidou.mybatisplus.service.IService;
import com.example.demo.entity.School;

public interface SchoolService extends IService<School> {
    public School getSchoolById(int id);
    // public Iterable<School> searchByES(QueryStringQueryBuilder builder);

}
