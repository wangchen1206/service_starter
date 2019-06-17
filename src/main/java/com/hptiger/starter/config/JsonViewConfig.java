/**
 * created Feb 8, 2019 by ypzhuang
 * 
 * Support  JsonView lib 
 */

package com.hptiger.starter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.monitorjbl.json.JsonViewSupportFactoryBean;

@Configuration
public class JsonViewConfig {
	@Autowired
	private ObjectMapper mapper;
	
	//注册自己封装的Bean
	@Bean
	public JsonViewSupportFactoryBean views() {
		return new JsonViewSupportFactoryBean(mapper);
	}
}
