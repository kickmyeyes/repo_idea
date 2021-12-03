package com.lagou.service;

import com.lagou.domain.Test;

import java.util.List;

/**
 * @author xyf
 * @date 2021/11/22 21:55
 * @description
 */
public interface TestService {

    //测试查询所有
    public List<Test> findAllTest();

}
