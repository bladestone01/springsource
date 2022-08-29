package org.code.ioc.beans.domain;

import lombok.Data;
import lombok.ToString;
import org.code.ioc.beans.annotation.Super;

@Data
@Super
@ToString(callSuper = true)
public class SuperUser extends User {
    private String address;

}
