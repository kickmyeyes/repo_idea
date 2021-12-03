package com.lagou.controller;

import com.lagou.domain.*;
import com.lagou.service.MenuService;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xyf
 * @date 2021/11/29 20:12
 * @description
 */

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /*
        查询所有角色&条件进行查询
     */
    @RequestMapping("/findAllRole")
    public ResponseResult findAllUserByPage(@RequestBody Role role){
        List<Role> allRole = roleService.findAllRole(role);
        ResponseResult responseResult = new ResponseResult(true,200,"查询所有角色(条件)成功",allRole);
        return responseResult;
    }

    /*
        新增&更新角色
    */
    @RequestMapping("/saveOrUpdateRole")
    public ResponseResult saveOrUpdateRole(@RequestBody Role role) {
        Date date = new Date();
        if (role.getId() == null){
            role.setCreatedTime(date);
            role.setUpdatedTime(date);
            roleService.saveRole(role);
            ResponseResult responseResult = new ResponseResult(true, 200, "新增角色成功", null);
            return responseResult;
        } else {
            role.setUpdatedTime(date);
            roleService.updateRole(role);
            ResponseResult responseResult = new ResponseResult(true, 200, "更新角色成功", null);
            return responseResult;
        }
    }

    /*
        根据id回显角色
    */
    @RequestMapping("/findRoleById")
    public ResponseResult findRoleById(@RequestParam Integer id){
        Role role = roleService.findRoleById(id);
        ResponseResult responseResult = new ResponseResult(true,200,"根据ID回显角色成功",role);
        return responseResult;
    }


    @Autowired
    private MenuService menuService;

    /*
        查询所有父子菜单信息(分配菜单的第一个接口)
     */
    @RequestMapping("/findAllMenu")
    public ResponseResult findSubMenuListByPid(){
        // -1表示查询所有的父子级菜单
        List<Menu> menuList = menuService.findSubMenuListByPid(-1);
        //响应数据
        Map<String, Object> map = new HashMap<>();
        map.put("parentMenuList",menuList);
        ResponseResult responseResult = new ResponseResult(true,200,"查询所有父子菜单信息成功",map);
        return responseResult;
    }

    /*
        根据角色id查询该角色关联的菜单信息
     */
    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(Integer roleId){
        List<Integer> menuByRoleId = roleService.findMenuByRoleId(roleId);
        ResponseResult responseResult = new ResponseResult(true,200,"根据角色id查询该角色关联的菜单信息成功",menuByRoleId);
        return responseResult;
    }

    /*
        为角色分配菜单
     */
    @RequestMapping("/RoleContextMenu")
    public ResponseResult RoleContextMenu(@RequestBody RoleMenuVO roleMenuVO){
        roleService.roleContextMenu(roleMenuVO);
        ResponseResult responseResult = new ResponseResult(true,200,"响应成功",null);
        return responseResult;
    }

    /*
        删除角色
     */
    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(Integer id){
        roleService.deleteRole(id);
        ResponseResult responseResult = new ResponseResult(true,200,"删除角色信息成功",null);
        return responseResult;
    }













    }
