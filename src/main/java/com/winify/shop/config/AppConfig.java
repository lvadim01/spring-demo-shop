package com.winify.shop.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Value("${spring.datasource.url}")
	private String datasourceUrl;
	
	@Bean 
	public DataSource getDataSource() { 
	    DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
	    dataSourceBuilder.url(datasourceUrl);
	    return dataSourceBuilder.build();  
	}
}
