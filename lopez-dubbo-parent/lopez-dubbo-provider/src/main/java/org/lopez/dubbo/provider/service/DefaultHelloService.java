package org.lopez.dubbo.provider.service;

import org.apache.dubbo.config.annotation.Service;
import org.lopez.dubbo.api.HelloService;
import org.springframework.beans.factory.annotation.Value;

@Service(version = "${dubbo.application.version}")
public class DefaultHelloService implements HelloService {

    @Value("${spring.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        return String.format("[%s] : Hello, %s", serviceName, name);
    }
}
