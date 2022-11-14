package org.code.ioc.beans.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.code.ioc.beans.enums.City;

@Data
@SuperBuilder
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;

    private City city;
}
