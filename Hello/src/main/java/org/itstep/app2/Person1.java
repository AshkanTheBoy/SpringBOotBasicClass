package org.itstep.app2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person1 {
    private Long id;
    private String name;
    private String surname;

    public Person1(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
}
