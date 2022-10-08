package org.code.ioc.container.overview.lookup;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyLookupTest {
    /**
     *
     */
    @Test
    @DisplayName("look up bean")
    public void lookupDemo() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup.xml");

        DependencyLookup lookup = (DependencyLookup) beanFactory.getBean("lookup");
        lookup.lookupByType(beanFactory);

        //基于注解，获取对象实例
        lookup.lookupByAnnotation(beanFactory);

        //基于类型，获取Map
        lookup.lookupMapByType(beanFactory);

        //查询对象，实时获取
        lookup.lookupBeanByRealtime(beanFactory);

        //延迟获取对象
        lookup.lookupBeanByLazy(beanFactory);
    }
}
