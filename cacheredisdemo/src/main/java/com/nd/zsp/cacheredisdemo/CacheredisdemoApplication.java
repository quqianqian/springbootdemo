package com.nd.zsp.cacheredisdemo;

import com.battcn.swagger.annotation.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@EnableSwagger2Doc
@SpringBootApplication
public class CacheredisdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheredisdemoApplication.class, args);
    }
}
