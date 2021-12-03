package com.lagou.dao;

import com.lagou.domain.PromotionAd;
import com.lagou.domain.Role;
import com.lagou.domain.Role_menu_relation;

import java.util.List;

/**
 * @author xyf
 * @date 2021/11/29 20:06
 * @description
 */
public interface RoleMapper {

    /*
        查询所有角色&条件进行查询
     */
    public List<Role> findAllRole(Role role);

    /*
        新增角色
     */
    public void saveRole(Role role);

    /*
        根据id回显角色
     */
    public Role findRoleById(Integer id);

    /*
        更新角色
     */
    public void updateRole(Role Role);

    /*
        根据角色id查询该角色关联的菜单信息
     */
    public List<Integer> findMenuByRoleId(Integer roleId);

    /*
        根据roleid清空中间表的关联关系
     */
    public void deleteRoleContextMenu(Integer rid);

    /*
        为角色分配菜单信息
     */
    public void roleContextMenu(Role_menu_relation role_menu_relation);

    /*
        删除角色
     */
    public void deleteRole(Integer roleid);












}
