package org.code.ioc.beans;

import org.code.ioc.beans.config.MyConfig;
import org.code.ioc.beans.domain.MyJavaBean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author chenjunfeng02
 * @version V1.0
 * @since 11/16/22 5:28 PM
 */
public class ExecutionOrderTest {

    @Test
    @DisplayName("Test Execution Order")
    void testExecOrder() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        MyJavaBean bean = (MyJavaBean) context.getBean("myJavaBean");
        System.out.println("===============下面输出结果============");
        System.out.println("描述：" + bean.getDesc());
        System.out.println("备注：" + bean.getRemark());
    }
}
