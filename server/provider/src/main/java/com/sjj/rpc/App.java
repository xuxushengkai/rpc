package com.sjj.rpc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName App
 * @Description TODO
 * Author shengjunjie
 * Date 2019/7/3 16:06
 **/
public class App {

    public static void main(String[] args) {
        System.out.println( "****************欢迎使用售票系统****************!" );
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        ((AnnotationConfigApplicationContext) context).start();
    }
}
