package org.code.ioc.beans.factory;

import org.code.ioc.beans.domain.User;

/**
 * @author chenjunfeng02
 */
public interface UserFactory {

    default User createUser() {
        return new User();
    }
}
