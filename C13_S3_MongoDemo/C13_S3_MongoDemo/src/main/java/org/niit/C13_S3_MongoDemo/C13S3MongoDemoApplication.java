package org.niit.C13_S3_MongoDemo;

import org.niit.C13_S3_MongoDemo.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class C13S3MongoDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(C13S3MongoDemoApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean jwtFilter(){
		FilterRegistrationBean frb=new FilterRegistrationBean<>();
		frb.setFilter(new JwtFilter());
		//frb.addUrlPatterns("/api/v1/customers/add","/api/v1/customers/get","");
		frb.addUrlPatterns("/api/v1/*");// addUrlPatter(String ...)// var-args
		return frb;
	}

}
