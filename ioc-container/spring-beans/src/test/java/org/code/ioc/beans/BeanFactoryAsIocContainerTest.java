package org.code.ioc.beans;

import org.code.ioc.beans.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.Bean;

import java.util.Map;

public class BeanFactoryAsIocContainerTest {

    @Test
    @DisplayName("测试容器Load Beans")
    void testLoadBeanDefinition() {
        //创建BeanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        int beanDefinitionCount = reader.loadBeanDefinitions(location);

        System.out.println("Bean Count:" + beanDefinitionCount);

        lookupCollectionByType(beanFactory);
    }

    public static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof BeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = ((ListableBeanFactory) beanFactory).getBeansOfType(User.class);

            System.out.println("All users:" + users);
        }
    }

}
