package com.zgc.saap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * @date 2020-04-28 19:00:52
 * @author yang
 */
@SpringBootApplication()
@MapperScan(basePackages = {"com.zgc.saap.persistent.dao"})
public class Application {
    public static void main( String[] args ){
    	SpringApplication.run(Application.class, args);   
    }
}
