package com.lagou.controller;


import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/PromotionAd")
public class PromotionAdController {

    @Autowired
    private PromotionAdService promotionAdService;

    /*
        分页查询广告信息
     */

    @RequestMapping("/findAllPromotionAdByPage")
    public ResponseResult findAllAdByPage(PromotionAdVO promotionAdVO) {
        PageInfo<PromotionAd> pageInfo = promotionAdService.findAllPromotionAdByPage(promotionAdVO);
        ResponseResult responseResult = new ResponseResult(true, 200, "广告分页查询成功", pageInfo);
        return responseResult;
    }

    /*
        广告图片上传
     */
    @RequestMapping("/PromotionAdUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        //1.判断是否为空
        if (file.isEmpty()){
            throw  new RuntimeException();
        }
        //2.获取项目部署路径
        String realPath = request.getServletContext().getRealPath("/");
        String substring = realPath.substring(0, realPath.indexOf("ssm-web"));
        //3.获取原文件名
        String originalFilename = file.getOriginalFilename();
        //4.生成新文件名
        String newFileName = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));
        //5.文件上传
        String uploadPath = substring + "upload\\";
        File filePath = new File(uploadPath, newFileName);
        //如果目录不存在就创建
        if (!filePath.getParentFile().exists()){
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录：" + filePath);
        }
        //图片上传
        file.transferTo(filePath);
        //6.将文件名和文件路径返回，进行响应
        Map<String, String> map = new HashMap<>();
        map.put("fileName",newFileName);
        map.put("filePath","http://localhost:8080/upload/" + newFileName);
        ResponseResult responseResult = new ResponseResult(true, 200, "图片上传成功", map);
        return responseResult;
    }

    /*
        新增&更新广告
    */
    @RequestMapping("/saveOrUpdatePromotionAd")
    public ResponseResult saveOrUpdatePromotionAd(@RequestBody PromotionAd promotionAd) {
        Date date = new Date();
        if (promotionAd.getId() == null){
            promotionAd.setCreateTime(date);
            promotionAd.setUpdateTime(date);
            promotionAdService.savePromotionAd(promotionAd);
            ResponseResult responseResult = new ResponseResult(true, 200, "新增广告成功", null);
            return responseResult;
        } else {
            promotionAd.setUpdateTime(date);
            promotionAdService.updatePromotionAd(promotionAd);
            ResponseResult responseResult = new ResponseResult(true, 200, "更新广告成功", null);
            return responseResult;
        }
    }

    /*
        根据id回显 广告数据
    */
    @RequestMapping("/findPromotionAdById")
    public ResponseResult findPromotionAdById(@RequestParam Integer id){
        PromotionAd promotionAd = promotionAdService.findPromotionAdById(id);
        ResponseResult responseResult = new ResponseResult(true,200,"根据ID回显广告成功",promotionAd);
        return responseResult;
    }

    /*
        广告动态上下线
     */
    @RequestMapping("/updatePromotionAdStatus")
    public ResponseResult updatePromotionStatus(@RequestParam Integer id, @RequestParam Integer status) {
        promotionAdService.updatePromotionAdStatus(id,status);
        ResponseResult responseResult = new ResponseResult(true,200,"广告动态上下线成功",null);
        return responseResult;
    }





























    }
