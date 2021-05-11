package com.bootproject.core.model;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 * @author 189****3363
 * @date 2021/05/11 09:30
 */
public class PageData<T> implements Serializable {

    // 目标页
    private int page;

    // 一页多少行
    private int capacity;

    // 总记录数
    private long total;

    // 当前的数据
    private List<T> records;

    public PageData(int page, int capacity) {
        this.page = page;
        this.capacity = capacity;
    }
  
    public static <T> PageData<T> from(PageInfo<T> pageInfo) {
        PageData<T> pageData = new PageData<>(pageInfo.getPageNum(), pageInfo.getPageSize());
        pageData.total = pageInfo.getTotal();
        pageData.records = pageInfo.getList();
        return pageData;
    }

    /**
     * 处理异常页容量
     * @author 189****3363
     * @date 2021/05/11 09:30
     */
    public int getCapacity () {
        return capacity <= 0 ? 10 : capacity;
    }

    /**
     * 计算总页码
     * @author 189****3363
     * @date 2021/05/11 09:30
     */
    public long getPageCount(){
        if(this.getTotal() % this.getCapacity() == 0){
            long pc = this.getTotal()/this.getCapacity();
            return pc == 0 ? 1 : pc;
        }
        return this.getTotal()/this.getCapacity() + 1;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

}