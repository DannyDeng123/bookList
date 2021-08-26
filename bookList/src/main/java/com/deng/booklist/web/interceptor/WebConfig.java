package com.deng.booklist.web.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
//				.excludePathPatterns("/login") 排除此路徑
				.addPathPatterns("/")	//此路徑增加欄截器
				.addPathPatterns("/api/books/**");
	}
}
