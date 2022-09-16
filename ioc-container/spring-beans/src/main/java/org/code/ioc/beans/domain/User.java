package org.code.ioc.beans.domain;

import lombok.Data;
import org.code.ioc.beans.enums.City;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;

    private City city;
}
