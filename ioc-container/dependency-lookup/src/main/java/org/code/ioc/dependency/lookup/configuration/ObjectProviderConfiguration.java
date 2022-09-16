package org.code.ioc.dependency.lookup.configuration;

import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;

public class ObjectProviderConfiguration {
    @Bean
    public String helloWorld() {
        return "Hello, world";
    }


}
