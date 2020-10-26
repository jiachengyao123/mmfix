package com.guli.util;

import com.guli.file.FastDFSFile;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;


/**
 * @auther Jia
 * @date 2020-06-23 16:17
 *
 * 实现fastDFS 文件管理
 *            文件上传
 *            文件删除
 *            文件下载
 *            文件信息获取
 *            storage信息获取
 *            Tracker 信息获取
 */
public class FastDFSutil {
    /**
     * 加载Tracker连接信息
     */
    static {
        try {
            //查找classPath下的文件路径
            String fileName = new ClassPathResource("fdfs_client_conf").getPath();
            //加载Tracker连接信息
            ClientGlobal.init(fileName);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String[] upload(FastDFSFile fastDFSFile) throws Exception{

        //附加参数
        NameValuePair[] meta_list=new NameValuePair[1];
        meta_list[0] =new NameValuePair("author",fastDFSFile.getAuthor());

        //创建一个TrackerClient访问客户端对象
        TrackerClient trackerClient = new TrackerClient();

        //通过TrackerClient访问TrackerServer服务，获取连接信息
        TrackerServer trackerServer = trackerClient.getConnection();

        //通过trackerServer的连接信息可以获取Storage的连接信息，创建StorageClient对象存储Storage的连接信息
        StorageClient storageClient = new StorageClient(trackerServer, null);

        /**
         * 通过storageClient访问storage，实现文件上传，并获取文件上传后的存储信息
         *  1.上传文件的字节数组
         *  2.文件的扩展名
         *  3.附近参数，比如：拍摄地址：北京
         *
         *  uploads[]
         *      uploads[0]:文件上传所存储的storage的组名  比如：group1
         *      uploads[1]:文件存储到storage上的文件名   比如：M00/02/44/1.jpg
         *
         */
        String[] uploads = storageClient.upload_file(fastDFSFile.getContent(), fastDFSFile.getExt(), meta_list);

        return uploads;

    }
}
