package org.code.ioc.beans.init;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.logging.Logger;

@Data
public class Dog implements DisposableBean, InitializingBean {
    private String name;

    @PostConstruct
    public void init() {
       System.out.println("PostConstruct...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy method.....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean....");
    }

    @PreDestroy
    public void destroyMethod() {
        System.out.println("PreDestory...");
    }


    public void customInit() {
        System.out.println("Custom init method");
    }

    public void customDestroy() {
        System.out.println("Custom destory method");
    }

}
