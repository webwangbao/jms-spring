package com.myimooc.jmsspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @Author : wangbao02
 * @Date : 14:23 2018/3/14/0014
 * @Description :
 */
@SpringBootApplication
public class JmsspringWebApp extends SpringBootServletInitializer {
    public static void main( String[] args )
    {
        SpringApplication.run(JmsspringWebApp.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JmsspringWebApp.class);
    }
}
