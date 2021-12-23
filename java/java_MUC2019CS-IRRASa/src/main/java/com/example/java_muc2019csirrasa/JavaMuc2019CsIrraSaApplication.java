package com.example.java_muc2019csirrasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class JavaMuc2019CsIrraSaApplication {

    public static void main(String[] args) {

        SpringApplication.run(JavaMuc2019CsIrraSaApplication.class, args);
    }

}
