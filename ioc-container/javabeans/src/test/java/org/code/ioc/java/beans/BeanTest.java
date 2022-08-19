package org.code.ioc.java.beans;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.stream.Stream;

public class BeanTest {
    @Test
    @DisplayName("introspect Bean")
    void testBean() throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        Stream.of(propertyDescriptors).forEach(propertyDescriptor -> {
            System.out.println("descriptor:" + propertyDescriptor.toString());
        });

    }
}
