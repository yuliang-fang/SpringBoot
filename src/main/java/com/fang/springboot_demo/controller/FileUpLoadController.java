package com.fang.springboot_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传Controller
 */

@Controller
public class FileUpLoadController {

    @RequestMapping("/index")
    public Object index(){
        return "index";  //这个Controller的注解是Controller，不是RestControler，返回的是resource/templates/index.html文件。
                        // 需要加入thymeleaf注解

    }


    /*
       文件上传代码  MultipartFile
     */
    //文件上传的路径
    private static final String filepath="/Users/haijuan/Documents/yuliangfang/workspace" +
            "/myTest/SpringBoot/src/main/resources/";

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file")MultipartFile file, HttpServletRequest request){
        String name=request.getParameter("name");
        System.out.println("传入的参数为"+name);

        long size = file.getSize();//获取文件大小
        System.out.println("传入大小为"+size);

        //获取文件名
        String fileName=file.getOriginalFilename();
        System.out.println("上传的文件名为"+fileName);

        //获取文件的后缀
        String suffixName=fileName.substring(fileName.lastIndexOf("."));

        //文件上传后的路径
        fileName=UUID.randomUUID()+suffixName;
        File dest=new File(filepath+fileName);//注意filepath最后面有个／

        try {
            //文件上传
            file.transferTo(dest);
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return"上传失败！";
    }


}
