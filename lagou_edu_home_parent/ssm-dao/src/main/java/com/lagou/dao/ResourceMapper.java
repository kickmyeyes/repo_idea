package com.lagou.dao;

import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVO;

import java.util.List;

/**
 * @author xyf
 * @date 2021/11/30 21:13
 * @description
 */
public interface ResourceMapper {

    /*
        资源分页&多条件查询资源
     */
    public List<Resource> findAllResourceByPage(ResourceVO resourceVO);













}
