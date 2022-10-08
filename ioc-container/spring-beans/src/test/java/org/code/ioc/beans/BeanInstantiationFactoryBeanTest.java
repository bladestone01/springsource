package org.code.ioc.beans;

import org.code.ioc.beans.domain.User;
import org.code.ioc.beans.factory.DefaultUserFactory;
import org.code.ioc.beans.factory.UserFactory;
import org.code.ioc.beans.factory.UserFactoryBean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Iterator;
import java.util.ServiceLoader;

public class BeanInstantiationFactoryBeanTest {

    @Test
    @DisplayName("factory bean in creating instance")
    void testFactoryBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Config.class);
        context.refresh();

        User user = context.getBean(User.class);
        System.out.println("User:" + user);
    }

    @Test
    @DisplayName("ServiceLoader Bean Creation")
    void testServiceLoader() throws Exception {
       ServiceLoader<UserFactory> serviceLoader = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());

       Iterator<UserFactory> iterator = serviceLoader.iterator();
       while (iterator.hasNext()) {
           UserFactory userFactory = iterator.next();
           System.out.println("Factory Bean:" + userFactory.createUser());
       }
    }

    @Test
    @DisplayName("Spring ServiceLoaderFactoryBean")
    void testServiceLoaderFactoryBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ServiceLoader<UserFactory> serviceLoader = context.getBean(ServiceLoader.class);

        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            UserFactory userFactory = iterator.next();
            System.out.println("Factory Bean:" + userFactory.createUser());
        }
    }

    @Test
    @DisplayName("create bean in BeanFactory")
    void testBeanFactory() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        AutowireCapableBeanFactory beanFactory = context.getAutowireCapableBeanFactory();

        UserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);
        System.out.println("User:" + userFactory.createUser());
        context.close();
    }


    @Configuration
    public static class Config {

        @Bean
        public User user() {
            return new User();
        }

        @Bean
        public FactoryBean userFactoryFactoryBean() {
            ServiceLoaderFactoryBean factoryBean = new ServiceLoaderFactoryBean();
            factoryBean.setServiceType(UserFactory.class);
            System.out.println("init the user factory bean");

            return factoryBean;
        }
    }
}
