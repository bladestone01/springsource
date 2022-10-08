package org.code.ioc.container.overview.inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class DependencyInjectTest {
    public static Logger log = LogManager.getLogger(DependencyInjectTest.class);

    @Test
    @DisplayName("inject test")
    public void testInject() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection.xml");
        UserRepository userRepo = applicationContext.getBean("userRepo", UserRepository.class);

        System.out.println("Users:" + Arrays.toString(userRepo.getUsers().toArray()));

        //获取BeanFactory, 获取不到BeanFactory
        //BeanFactory beanFactory = applicationContext.getBean(BeanFactory.class);
        log.info("BeanFactory:{}", userRepo.getBeanFactory());

        ObjectFactory objectFactory = userRepo.getObjectFactory();

        assertThat(objectFactory.getObject()).isEqualTo(applicationContext);
        Environment environment = (Environment) applicationContext.getBean(Environment.class);
        log.info("Environment:{}", environment);
    }
}
