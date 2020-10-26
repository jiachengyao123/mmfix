package com.guli.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Mybatis-Plus 自动填充时间
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
            //添加时自动填充
            this.setFieldValByName("gmtCreate",new Date(),metaObject);
            this.setFieldValByName("gmtModified",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //修改时自动填充
        this.setFieldValByName("gmtModified",new Date(),metaObject);
    }
}
