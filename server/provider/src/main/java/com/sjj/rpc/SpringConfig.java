package com.sjj.rpc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SpringConfig
 * @Description TODO
 * Author shengjunjie
 * Date 2019/7/3 20:18
 **/
@Configuration
@ComponentScan(basePackages = "com.sjj.rpc")
public class SpringConfig {

    @Bean(name = "rpcServer")
    public RpcServer rpcServer(){return new RpcServer(9090);}
}
