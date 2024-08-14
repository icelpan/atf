package com.myproject;

import com.github.tomakehurst.wiremock.WireMockServer;
import lombok.extern.slf4j.Slf4j;
import org.application.config.CelpanWireMockConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@ComponentScan(basePackageClasses = {CelpanWireMockConfig.class})
@ConfigurationProperties(prefix = "wiremock.celpan")
public class CelpanMockedConfig {

    @Autowired
    private WireMockServer celpanWireMock;

    @Autowired
    private ConfigurationService configurationService;

    @Bean(name = "celpanMocked", destroyMethod = "stop")
    public WireMockServer celpanMocked(){
        celpanWireMock.start();
        log.info("Running wiremock server on port: {}", celpanWireMock.port());
        return celpanWireMock;
    }
}
