package com.example.demo.services.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.dao.SchoolDao;
import com.example.demo.entity.School;
import com.example.demo.services.SchoolService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SchoolServiceImpl extends ServiceImpl<SchoolDao, School> implements SchoolService {
    @Override
    public School getSchoolById(int id) {
        return baseMapper.selectById(id);
    }

    /*@Override
    public Iterable<School> searchByES(QueryStringQueryBuilder builder) {
        return baseMapper.search(builder);
    }*/
}

