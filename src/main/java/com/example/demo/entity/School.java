package com.example.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@TableName("school")
@Document(indexName = "education", type = "school")
public class School implements Serializable {
    @TableId("ID")
    private int id;

    @TableField("NAME")
    private String name;

    @TableField("RANGE")
    private int range;

    @TableField("AGE")
    private int age;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRange() { return range; }
    public void setRange(int range) { this.range = range; }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name +
                ", range=" + range +
                ", age=" + age +
                '}';
    }
}
