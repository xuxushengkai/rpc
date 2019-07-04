package com.sjj.rpc;


import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName RpcService
 * @Description TODO
 * Author shengjunjie
 * Date 2019/7/3 20:14
 **/
@Target(ElementType.TYPE) //类/接口
@Retention(RetentionPolicy.RUNTIME)
@Component //被spring进行扫描
public @interface RpcService{

    Class<?> value();//拿到接口

    String version() default "";//版本号
}
