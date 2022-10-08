package org.code.ioc.beans;

import org.code.ioc.beans.init.Dog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanExecuteOrderTest {

    @Test
    @DisplayName("execution order in Code")
    void testExecutionOrder() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Dog dog = context.getBean(Dog.class);
        System.out.println("The Dog is created.....");
        context.close();
        System.out.println("The message after context is close");

    }

    @Configuration
    public static class Config {

        @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
        public Dog dog() {
            return new Dog();
        }
    }
}
