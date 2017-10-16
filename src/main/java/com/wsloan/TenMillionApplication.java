package com.wsloan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication //springboot 启动注解
@EnableWebMvc       //mvc启动注解
@MapperScan("com.wsloan.Dao")  //mapper扫描
@EnableTransactionManagement    //开启事务支持  然后在需要的service 加@Transactional    ！！！多个数据源的话要配置多个事务管理器！！！
public class TenMillionApplication  {



    //springboot 启动方法
    public static void main(String[] args){
        SpringApplication.run(TenMillionApplication.class,args);
    }


}
