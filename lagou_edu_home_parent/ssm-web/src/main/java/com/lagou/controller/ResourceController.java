package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xyf
 * @date 2021/11/30 21:29
 * @description
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    /*
        资源分页&多条件查询资源
     */
    @RequestMapping("/findAllResource")
    public ResponseResult findAllResourceByPage(@RequestBody ResourceVO resourceVO){
        PageInfo<Resource> pageInfo = resourceService.findAllResourceByPage(resourceVO);
        ResponseResult responseResult = new ResponseResult(true,200,"资源分页&多条件查询资源查询成功",pageInfo);
        return responseResult;
    }



















}