package org.code.ioc.beans;

import org.code.ioc.beans.domain.DestoryUser;
import org.code.ioc.beans.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.logging.Logger;

@Import(BeanDefinitionCreationTest.BeanConfig.class)
public class BeanDefinitionCreationTest {
    public static Logger logger = Logger.getLogger("test");

    @Test
    @DisplayName("Builder创建")
    void beanDefinitionCreate() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanDefinitionCreationTest.class);

        registerUserBeanDefinition(context, "", User.class);
        registerBeanDefinition(context, "blade-user", User.class);
        context.refresh();

        System.out.println("Config Beans:" + context.getBeansOfType(BeanConfig.class));
        System.out.println("User Config Beans:" + context.getBeansOfType(User.class));
    }

    @Test
    @DisplayName("Destory Method")
    void testDestoryInvocation() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        DestoryUser destoryUser = context.getBean("destroy1", DestoryUser.class);
        System.out.println("destroy:" + destoryUser);

        context.removeBeanDefinition("destroy1");

        DestoryUser destory2 = context.getBean("destroy1", DestoryUser.class);
        System.out.println("destroy2:" + destoryUser);
    }


    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName, Class<?> beanClass) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
        builder.addPropertyValue("age", 25)
                .addPropertyValue("name", "AliceFan");

        if (StringUtils.hasText(beanName)) {
            //register Bean
            registry.registerBeanDefinition(beanName, builder.getBeanDefinition());
        }
        else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(builder.getBeanDefinition(), registry);
        }

    }

    /**
     * 创建命名的Bean.
     *
     * @param registry
     * @param beanName
     * @param beanClass
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry registry, String beanName, Class<?> beanClass) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
        builder.addPropertyValue("age", 25)
                .addPropertyValue("name", "AliceFan");

        //register Bean
        registry.registerBeanDefinition(beanName, builder.getBeanDefinition());
    }

    @Component
    public static class BeanConfig {
        @Bean(value = {"user", "stone-user"})
        public User user() {
            User user = new User();
            user.setAge(12);
            user.setName("Jackie Li");

            return user;
        }

        @Bean(name="destroy1", initMethod = "initOne", destroyMethod = "destroyOne")
        public DestoryUser destoryUser() {
            return DestoryUser.builder().age(12).name("Ajckie").build();
        }
    }


}
