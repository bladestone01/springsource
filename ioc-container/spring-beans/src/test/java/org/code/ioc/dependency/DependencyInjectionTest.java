package org.code.ioc.dependency;

import org.code.ioc.beans.domain.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

public class DependencyInjectionTest {
    @Test
    @DisplayName("依赖注入测试Demo")
    void testDI() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-inject-context.xml");

        UserRepository userRepository = context.getBean("userRepository", UserRepository.class);

        System.out.println("User Repo:" + userRepository.getUsers());
        System.out.println("Bean Factory" + userRepository.getBeanFactory());

        ObjectFactory userFactory = userRepository.getObjectFactory();
        System.out.println(userFactory.getObject() == context);

        //org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'org.springframework.beans.factory.BeanFactory' available
        //System.out.println("Bean Factory:" + context.getBean(BeanFactory.class));

        Environment environment = context.getBean(Environment.class);
        System.out.println("environment:" + environment);
    }
}
