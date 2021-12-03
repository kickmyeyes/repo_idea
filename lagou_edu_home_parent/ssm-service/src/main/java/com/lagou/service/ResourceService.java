package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVO;

import java.util.List;

/**
 * @author xyf
 * @date 2021/11/30 21:26
 * @description
 */
public interface ResourceService {

    /*
       资源分页&多条件查询资源
    */
    public PageInfo<Resource> findAllResourceByPage(ResourceVO resourceVO);







}
