package com;


import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@SpringBootApplication
@ComponentScan(basePackages = {"com.controller","com.service","com,entity","com,mapper"})
@MapperScan(basePackages ={"com.mapper"})
public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		//测试c3p0配置
		//DataSource dataSource = context.getBean(DataSource.class);
        //System.out.println(dataSource.getClass());
	}
	
	/**  
     * 文件上传配置  
     * @return  
     */  
    @Bean  
    public MultipartConfigElement multipartConfigElement() {  
        MultipartConfigFactory factory = new MultipartConfigFactory();  
        //单个文件最大  
        factory.setMaxFileSize("20MB"); //KB,MB  
        /// 设置总上传数据总大小  
        //factory.setMaxRequestSize("102400KB");
        return factory.createMultipartConfig();  
    }  
}
