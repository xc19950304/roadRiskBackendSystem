package com.xc.roadRisk.common.vo;

import com.baomidou.mybatisplus.plugins.Page;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class PageList<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 862020554935213342L;

    //当前页码
    private int currentPage;

    //每页条数
    private int pageSize;

    // 查询的实体对象集合
    private Collection<T> entities;

    //实体对象数量
    private long count;

    public PageList() {

    }

    public PageList(Page<T> page) {
        if (null != page) {
            this.currentPage = page.getCurrent();
            this.pageSize = page.getSize();
            this.count = page.getTotal();
            this.entities = page.getRecords();
        }
    }

    public PageList(List<T> list) {
        this.pageEntity(0, 0, list, 0);
    }

    public PageList(int currentPage, int pageSize, Collection<T> entities, long count) {
        this.pageEntity(currentPage, pageSize, entities, count);
    }

    private void pageEntity(int currentPage, int pageSize, Collection<T> entities, long count) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.entities = entities;
        this.count = count;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Collection<T> getEntities() {
        return entities;
    }

    public void setEntities(Collection<T> entities) {
        this.entities = entities;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

}
