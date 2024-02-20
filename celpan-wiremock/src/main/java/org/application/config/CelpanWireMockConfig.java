package org.application.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.Slf4jNotifier;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;

@Configuration
@PropertySource(value = {"classpath:wiremock.properties", "classpath:wiremock-celpan.properties"},
        ignoreResourceNotFound = true)
@ConfigurationProperties(prefix = "wiremock.celpan")
@Getter
@Setter
@NoArgsConstructor
public class CelpanWireMockConfig {
    private Integer port;
    private Integer httpsPort;
    private String bindAddress;
    private String usingFilesUnderClasspath;
    private String baseUrl;
    private boolean verboseLogging;

    @Bean(
            name = {"celpanWireMockConfiguration"}
    )
    public WireMockConfiguration wireMockConfiguration(ResourceLoader resourceLoader) throws IOException {
        WireMockConfiguration config = WireMockConfiguration.options().port(this.port).httpsPort(this.httpsPort).bindAddress(this.bindAddress).usingFilesUnderClasspath(this.usingFilesUnderClasspath).notifier(new Slf4jNotifier(this.verboseLogging));
        return config;
    }

    @Bean(
            name = {"celpanWireMock"}
    )
    public WireMockServer wireMockServer(WireMockConfiguration celpanWireMockConfiguration){
        WireMockServer wireMockServer = new WireMockServer(celpanWireMockConfiguration);
        wireMockServer.setGlobalFixedDelay(0);
        return wireMockServer;
    }
}
