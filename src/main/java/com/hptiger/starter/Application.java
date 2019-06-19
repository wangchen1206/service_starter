package com.hptiger.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableCaching
@EnableAsync
@EnableScheduling
@MapperScan("com.hptiger.starter.mapper")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * 允许/api/** ,/app/**路径下，允许跨域请求。
	 * @return
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**")
						.allowedHeaders("*")
						.allowedMethods("*")
						.allowedOrigins("*");
				registry.addMapping("/app/**")
						.allowedHeaders("*")
						.allowedMethods("*")
						.allowedOrigins("*");
			}
		};
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
