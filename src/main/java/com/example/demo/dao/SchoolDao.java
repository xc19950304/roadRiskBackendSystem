package com.example.demo.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.entity.School;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface SchoolDao extends BaseMapper<School> {
    School getSchoolById(@Param("id") int id);
}
