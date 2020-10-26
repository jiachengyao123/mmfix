package com.guli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @auther Jia
 * @date 2020-06-23 15:46
 */
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//排除掉数据库自动加载

@SpringBootApplication
public class FileApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class,args);
    }
}
