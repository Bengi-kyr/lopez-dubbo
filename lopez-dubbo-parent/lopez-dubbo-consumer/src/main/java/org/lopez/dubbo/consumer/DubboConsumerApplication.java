package org.lopez.dubbo.consumer;

import org.apache.dubbo.config.annotation.Reference;
import org.lopez.dubbo.api.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
public class DubboConsumerApplication {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference(version = "${dubbo.application.version}")
    private HelloService helloService;

    @Bean
    public ApplicationRunner runner() {
        return args -> logger.info(helloService.sayHello("mercyblitz"));
    }

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class).close();
    }
}
