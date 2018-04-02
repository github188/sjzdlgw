package com.hbdl.web.sys.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zgq on 2016/10/1.
 */
public class PageForm implements java.io.Serializable{

    /**
     * 服务器状态
     * 200 300 301
     */
    private String status="200";
    /**
     * 关键字
     */
    private String keywords="";
    /**
     * 当前页
     */
    private int pageNum = 1;
    /**
     * 每页条数
     */
    private int numPerPage=20;
    /**
     * order by 字段名
     */
    private String orderField="";
    /**
     * 排序方式：ASC/DESC
     */
    private String orderDirection="";
    /**
     * 总条数
     */
    private long totalCount=0L;
    /**
     * 分页数据
     */
    private List listDatas=new ArrayList();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }

    public String getOrderField() {
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public String getOrderDirection() {
        return this.orderDirection;
    }

    public void setOrderDirection(String orderDirection) {
        this.orderDirection = orderDirection;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List getListDatas() {
        return listDatas;
    }

    public void setListDatas(List listDatas) {
        this.listDatas = listDatas;
    }

    public PageForm() {
    }
}
