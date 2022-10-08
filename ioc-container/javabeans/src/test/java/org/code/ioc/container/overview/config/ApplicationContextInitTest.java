package org.code.ioc.container.overview.config;

import org.code.ioc.container.overview.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextInitTest {

    @Test
    @DisplayName("注解初始化容器")
    void annotationInitContext() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DemoConfig.class);
        context.refresh();

        User user = context.getBean(User.class);
        assertThat(user.getAge()).isEqualTo(12);
        context.close();
    }

    @Test
    @DisplayName("配置文件初始化容器")
    void configInitContext() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        Integer count = reader.loadBeanDefinitions("classpath:/META-INF/dependency-lookup.xml");

        assertThat(count).isEqualTo(4);
    }
}
