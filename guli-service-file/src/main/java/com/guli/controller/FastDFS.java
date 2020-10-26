package com.guli.controller;

import com.guli.file.FastDFSFile;
import com.guli.util.FastDFSutil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @auther Jia
 * @date 2020-06-23 16:58
 */
@RestController
@RequestMapping("upload")
@CrossOrigin
public class FastDFS {


    @PostMapping
    public String upload(@RequestParam("file")MultipartFile file) throws Exception {
        FastDFSFile fastDFSFile = new FastDFSFile(
                file.getOriginalFilename(), //文件名字 比如 1.jpg
                file.getBytes(),            //文件字节数组
                StringUtils.getFilenameExtension(file.getOriginalFilename())//获取文件扩展名 比如 jpg  png
        );

        //调用FastDFSutil工具类将文件上传到FastFDS中
        String[] upload = FastDFSutil.upload(fastDFSFile);

        //拼接访问地址
        String fileURL="http://39.106.52.152:8080"+upload[0]+"/"+upload[1];
        return fileURL;
    }

}
