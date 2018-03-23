package com.adminportal;

import com.adminportal.utility.Converter.CategoryConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class AdminPortalApplication extends WebMvcConfigurerAdapter {
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new CategoryConverter());

	}
	public static void main(String[] args) {
		SpringApplication.run(AdminPortalApplication.class, args);
	}
}
