package org.code.ioc.beans.domain;

import lombok.Data;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

@Data
public class UserRepository {
    //集合元素
    private Collection<User> users;
    //非内建Bean
    private BeanFactory beanFactory;

    private ObjectFactory<ApplicationContext> objectFactory;
}
