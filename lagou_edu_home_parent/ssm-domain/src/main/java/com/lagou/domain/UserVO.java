package com.lagou.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author xyf
 * @date 2021/11/27 22:34
 * @description
 */
public class UserVO {

    //当前页
    private Integer currentPage;

    //每页显示的条数
    private Integer pageSize;

    //用户名(手机号)
    private String username;

    //注册起始时间  默认2020/11/11   前台传递2020-11-11
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startCreateTime;

    //注册结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endCreateTime;

    private Integer userId;

    private List<Integer> roleIdList;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Integer> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Integer> roleIdList) {
        this.roleIdList = roleIdList;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getStartCreateTime() {
        return startCreateTime;
    }

    public void setStartCreateTime(Date startCreateTime) {
        this.startCreateTime = startCreateTime;
    }

    public Date getEndCreateTime() {
        return endCreateTime;
    }

    public void setEndCreateTime(Date endCreateTime) {
        this.endCreateTime = endCreateTime;
    }

}