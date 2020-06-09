package com.example.webservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class FirstResTprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstResTprojectApplication.class, args);
		System.out.println("Started App");
	}
	@Bean
	public LocaleResolver localResolver() {
		SessionLocaleResolver localReslover = new SessionLocaleResolver();
		localReslover.setDefaultLocale(Locale.US);
		return localReslover;
	}
	@Bean
	public ResourceBundleMessageSource bundleMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
}
