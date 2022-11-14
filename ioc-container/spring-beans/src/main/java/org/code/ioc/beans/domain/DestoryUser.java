package org.code.ioc.beans.domain;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author chenjunfeng02
 * @version V1.0
 * @since 11/14/22 7:50 PM
 */
@Data
@SuperBuilder
public class DestoryUser extends User {
    public void destroyOne() {
        System.out.println("Destory Custom Method");
    }

    public void initOne() {
        System.out.println("Init One");
    }
}
