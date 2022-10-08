package org.code.ioc.container.overview.lookup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.code.ioc.container.overview.annotation.Super;
import org.code.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;

import java.util.List;
import java.util.Map;

public class DependencyLookup {
    public static Logger log = LogManager.getLogger(DependencyLookup.class);
    public void lookupByType(BeanFactory beanFactory) {
        log.info("Lookup byType:{}", beanFactory);

        User user = beanFactory.getBean(User.class);
        log.info("user:{}", user);
    }

    public void lookupMapByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;

            Map<String, User> users = (Map<String, User>) listableBeanFactory.getBeansOfType(User.class);
            log.info("User in Map:{}", users);
        }
    }

    public void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);

            log.info("Super:{}", users);
        }
    }

    public void lookupBeanByRealtime(BeanFactory beanFactory) {
        User user = (User)beanFactory.getBean("user");
        log.info("Load Bean, User:{}", user);
    }

    public void lookupBeanByLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();

        log.info("Lazy Loading, User:{}", user);
    }
}
