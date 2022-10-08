package org.code.ioc.container.overview.config;

import org.code.ioc.container.overview.domain.User;
import org.springframework.context.annotation.Bean;

public class DemoConfig {
    @Bean
    public User user() {
        User user = new User();
        user.setAge(12);
        user.setName("Alice Wu");

        return user;
    }
}
