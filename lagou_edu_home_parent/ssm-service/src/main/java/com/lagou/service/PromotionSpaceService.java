package com.lagou.service;

import com.lagou.domain.PromotionSpace;

import java.util.List;

public interface PromotionSpaceService {

    /*
        查询所有广告位
     */
    public List<PromotionSpace> findAllPromotionSpace();

    /*
        新增广告位
    */
    public void savePromotionSpace(PromotionSpace promotionSpace);

    /*
        根据ID回显广告位信息
     */
    public PromotionSpace findPromotionSpaceById(Integer id);

    /*
       更新广告位
    */
    public void updatePromotionSpace(PromotionSpace promotionSpace);










}
