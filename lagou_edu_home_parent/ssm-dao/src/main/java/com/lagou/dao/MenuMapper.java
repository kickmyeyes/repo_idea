package com.lagou.dao;

import com.lagou.domain.Menu;

import java.util.List;

/**
 * @author xyf
 * @date 2021/11/29 21:09
 * @description
 */
public interface MenuMapper {

    /*
        查询所有父子菜单信息
     */
    public List<Menu> findSubMenuListByPid(Integer pid);

    /*
        查询所有菜单信息
     */
    public List<Menu> findAllMenu();

    /*
        根据ID查询menu
     */
    public Menu findMenuById(Integer id);
}
