package com.afeng.domain;

import java.util.List;

public class PageBean<T> {
    private int pageNumber;//当前的页数
    private int pageSize;//每页显示条数
    private int totalRecord;//总记录数
    private int totalPage;//总页数
    private int startIndex;//当前页起始编号
    private List<T> data;//当前页存储的数据

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public PageBean(int pageNumber, int pageSize, int totalRecord) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        //如果是默认值的话 那么页数即等于记录数 否则就向上取整
        this.totalPage = (this.totalRecord + this.pageNumber - 1) / this.pageSize;
        //起始索引
        this.startIndex =(this.pageNumber-1)*this.pageSize+1;


    }
}
