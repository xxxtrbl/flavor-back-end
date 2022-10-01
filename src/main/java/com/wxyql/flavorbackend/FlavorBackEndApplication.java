package com.wxyql.flavorbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.wxyql.flavorbackend.mapper")
@SpringBootApplication
public class FlavorBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlavorBackEndApplication.class, args);
    }

}
