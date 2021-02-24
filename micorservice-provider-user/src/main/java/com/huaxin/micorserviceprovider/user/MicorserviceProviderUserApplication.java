package com.huaxin.micorserviceprovider.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicorserviceProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicorserviceProviderUserApplication.class, args);
    }

}
