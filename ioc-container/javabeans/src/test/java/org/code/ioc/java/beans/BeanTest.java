package org.code.ioc.java.beans;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.beans.*;
import java.util.stream.Stream;

public class BeanTest {
    @Test
    @DisplayName("introspect Bean")
    void testBean() throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        Stream.of(propertyDescriptors).forEach(propertyDescriptor -> {
            System.out.println("descriptor:" + propertyDescriptor.toString());

            Class<?> propertyType = propertyDescriptor.getPropertyType();
            String propertyName = propertyDescriptor.getName();

            if (propertyName.equals("age")) {
                propertyDescriptor.setPropertyEditorClass(StringToIntPropertyEditor.class);
                //propertyDescriptor.createPropertyEditor();
            }
            
        });

    }

    static class StringToIntPropertyEditor extends PropertyEditorSupport {
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
            Integer value = Integer.parseInt(text);
            setValue(value);
        }
    }
}
