package org.code.ioc.container.overview.domain;

import lombok.Data;
import lombok.ToString;
import org.code.ioc.container.overview.annotation.Super;

@Data
@ToString(callSuper = true)
@Super
public class SuperUser extends User {
    private String address;
}
