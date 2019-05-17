package com.xc.roadRisk.common.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@Configuration
@ConditionalOnClass(Docket.class)
@EnableSwagger2
public class SwaggerAutoConfig {

    public final static String CURRENT_VERSION = "v1";
    public final static String COMPATIBLE_VERSION = "v1,v2";

    @Bean
    public Docket docket(@Value("${swagger.enable:true}") boolean enableSwagger) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .title("路域灾害风险管理系统")
                                .description("当前API版本" + CURRENT_VERSION + " 兼容API版本" + COMPATIBLE_VERSION)
                                .version(CURRENT_VERSION)
                                .build())
                .select().apis(RequestHandlerSelectors.basePackage("com.xc.roadRisk"))
                .build()
                .enable(enableSwagger);
    }
}
