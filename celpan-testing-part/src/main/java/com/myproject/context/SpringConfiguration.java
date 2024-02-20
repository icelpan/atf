package com.myproject.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = {
        "com.myproject"
})
@PropertySource(value = {
        "classpath:application-${spring.profiles.active}.properties",
        "classpath:application.properties"
},
        ignoreResourceNotFound = true)
public class SpringConfiguration {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public ApplicationContext applicationContext() {
        return new AnnotationConfigApplicationContext();
    }

}
