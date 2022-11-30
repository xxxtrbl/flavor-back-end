package com.wxyql.flavorbackend.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class BaseHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Object createTime = this.getFieldValByName("create_time", metaObject);
        Object updateTime = this.getFieldValByName("revise_time", metaObject);

        //如果没手动设置时间值，就自动填充当前时间,如果有手动设置值，以设置值为准
        if (Objects.isNull(createTime)) {
            this.setFieldValByName("create_time", new Date(), metaObject);
        }

        if (Objects.isNull(updateTime)) {
            this.setFieldValByName("revise_time", new Date(), metaObject);
        }
    }

    //修改时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateTime = this.getFieldValByName("revise_time", metaObject);

        if (Objects.isNull(updateTime)) {
            this.setFieldValByName("revise_time", new Date(), metaObject);
        }
    }
}