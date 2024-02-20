package org.application;

import com.github.tomakehurst.wiremock.WireMockServer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "org.application"
})
@RequiredArgsConstructor
public class CelpanMocked implements ApplicationRunner {

    private final WireMockServer wireMockServer;

    public static void main(final String[] args) {
        SpringApplication.run(CelpanMocked.class, args);
    }

    @Override
    public void run(final ApplicationArguments args) {
        wireMockServer.start();
    }
}