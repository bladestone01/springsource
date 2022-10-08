package org.code.ioc.container.overview.inject;

import lombok.Data;
import org.code.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;
import java.util.List;

@Data
public class UserRepository {
    //自定义Bean
    private Collection<User> users;

    //内置非Bean对象（依赖）
    private BeanFactory beanFactory;

    private ObjectFactory<ApplicationContext> objectFactory;
}
