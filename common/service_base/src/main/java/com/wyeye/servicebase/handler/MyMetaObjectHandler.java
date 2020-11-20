package com.wyeye.servicebase.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 添加自动填充创建修改时间
 *
 * @author wyeye
 * @creed: Talk is cheap,show me the code
 * @date 2020/11/20 2:37 下午
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createdDate", new Date(), metaObject);
        this.setFieldValByName("modifiedDate", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("modifiedDate", new Date(), metaObject);
    }
}
