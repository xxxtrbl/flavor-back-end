package com.wxyql.flavorbackend.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Component
public class BaseHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Object createTime = this.getFieldValByName("createTime", metaObject);
        Object updateTime = this.getFieldValByName("reviseTime", metaObject);

        if (Objects.isNull(createTime)) {
            this.setFieldValByName("createTime", new Date(), metaObject);
        }

        if (Objects.isNull(updateTime)) {
            this.setFieldValByName("reviseTime", new Date(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateTime = this.getFieldValByName("reviseTime", metaObject);

        if (Objects.isNull(updateTime)) {
            this.setFieldValByName("reviseTime", new Date(), metaObject);
        }
    }
}