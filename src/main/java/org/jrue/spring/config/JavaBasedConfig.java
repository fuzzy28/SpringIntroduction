package org.jrue.spring.config;

import org.jrue.spring.model.Statistics;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaBasedConfig {

	@Bean
	public Statistics statistics() {
		return new Statistics();
	}
	
}
