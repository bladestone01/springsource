package org.code.ioc.dependency.lookup;

import org.code.ioc.dependency.lookup.configuration.ObjectProviderConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ObjectProviderTest {

    @Test
    @DisplayName("object provider test")
    public void testSingleObjLookup() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ObjectProviderConfiguration.class);
        context.refresh();

        lookupObject(context);

        context.close();
    }


    /**
     * 单个对象的延迟加载
     *
     * @param context
     */
    public static void lookupObject(AnnotationConfigApplicationContext context) {
        ObjectProvider<String> objectProvider = context.getBeanProvider(String.class);

        System.out.println("Bean Info:" + objectProvider.getObject());
    }
}
