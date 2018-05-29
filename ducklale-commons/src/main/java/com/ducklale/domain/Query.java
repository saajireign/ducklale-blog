package com.ducklale.domain;

public class Query {
    private Integer pageSize=10;
    private Integer pageNo=1;
    private Integer offset;
    private Integer limit;
    private String orderBy;

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getOffset() {
        return offset;
    }
    public void calcOffsetAndLimit(){
        offset = (pageNo-1)*pageSize;
        limit = pageSize;
    }


    public Integer getLimit() {
        return limit;
    }
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNum) {
        this.pageNo = pageNum;
    }
}
