package com.wsloan.Util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2  //启动swagger2
@Configuration   //定义一个配置类
/**
 *    swagger  生成接口文档的类（也算配置）
 */
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.wsloan.Controller"))
                .paths(PathSelectors.any())
                .build();
    }
    //构建 api文档的详细信息函数
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("聚财管理系统接口API文档")
                //创建人
                .contact(new Contact("林磊","www.wsloan.com","625052303@qq.com"))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .termsOfServiceUrl("http://192.168.22.96")
                .build();
    }
}