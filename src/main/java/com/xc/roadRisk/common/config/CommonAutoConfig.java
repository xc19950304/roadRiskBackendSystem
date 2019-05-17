package com.xc.roadRisk.common.config;

import com.xc.roadRisk.common.exception.GlobalExceptionHandler;
import com.xc.roadRisk.common.id.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CommonAutoConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @ConditionalOnProperty(name = {"snowflake.workerId", "snowflake.datacenterId"})
    public SnowflakeIdWorker snowflakeIdWorker(@Value("${snowflake.workerId}") long workerId,
                                               @Value("${snowflake.datacenterId}") long datacenterId) {
        return new SnowflakeIdWorker(workerId, datacenterId);
    }

    /**
     * 支持接口跨域
     *
     * @return
     */
    @Bean
    public WebMvcConfigurer webCorsConfig() {
        WebMvcConfigurer webCorsConfig = new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS", "HEAD")
                        .maxAge(3600)
                        .allowCredentials(true);
            }
        };
        return webCorsConfig;
    }

    @Bean
    public GlobalExceptionHandler exceptionHandler() {
        return new GlobalExceptionHandler();
    }
}
