package com.lagou.dao;

import com.lagou.domain.Test;

import java.util.List;

/**
 * @author xyf
 * @date 2021/11/22 20:49
 * @description
 */
public interface TestMapper {

    //测试查询所有
    public List<Test> findAllTest();

}
